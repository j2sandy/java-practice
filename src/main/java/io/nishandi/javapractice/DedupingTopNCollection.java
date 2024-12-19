import java.util.function.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DedupingTopNCollection<K, E> {

    private final int maxCapacity; // Maximum capacity of the collection
    private final Comparator<E> comparator; // Comparator for ordering
    private final Function<E, K> keyMapper; // Key extractor for deduplication
    private final Map<K, E> elementMap; // Map to enforce deduplication
    private final PriorityQueue<E> priorityQueue; // Min-heap for top N elements

    public DedupingTopNCollection(int maxCapacity, Comparator<E> comparator, Function<E, K> keyMapper) {
        this.maxCapacity = maxCapacity;
        this.comparator = comparator;
        this.keyMapper = keyMapper;
        this.elementMap = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>(comparator.reversed()); // Max-heap
    }

    /**
     * Adds an element to the collection.
     */
    public boolean add(E e) {
        K key = keyMapper.apply(e);

        // If the element with the same key exists, check if the new one is better
        if (elementMap.containsKey(key)) {
            E existing = elementMap.get(key);
            if (comparator.compare(e, existing) > 0) {
                // Remove the existing element and add the new one
                elementMap.put(key, e);
                priorityQueue.remove(existing);
                priorityQueue.offer(e);
                return true;
            }
            return false; // The new element is not better
        }

        // If it's a new key and we're under max capacity, add directly
        if (priorityQueue.size() < maxCapacity) {
            elementMap.put(key, e);
            priorityQueue.offer(e);
            return true;
        }

        // If the queue is full, check if the new element is better than the smallest
        E smallest = priorityQueue.peek();
        if (comparator.compare(e, smallest) > 0) {
            // Remove the smallest, add the new element
            priorityQueue.poll();
            elementMap.remove(k);
            elementMap.put(key, e);
            priorityQueue.offer(e);
            return true;
        }

        // Element not added (not better than existing elements)
        return false;
    }

    /**
     * Returns the elements in the collection in descending order.
     */
    public List<E> getElements() {

        List<E> result = new ArrayList<>(priorityQueue);
        result.sort(comparator.reversed()); // Sort in descending order
        return result;

    }

    public static void main(String[] args) {
        // Example usage
        class Item {
            String name;
            int value;

            Item(String name, int value) {
                this.name = name;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Item{name='" + name + "', value=" + value + "}";
            }
        }

        Comparator<Item> comparator = Comparator.comparingInt(i -> i.value); // Compare by value
        Function<Item, String> keyMapper = item -> item.name; // Deduplicate by name

        DedupingTopNCollection<String, Item> collection = new DedupingTopNCollection<>(3, comparator, keyMapper);

        collection.add(new Item("Apple", 10));
        collection.add(new Item("Banana", 20));
        collection.add(new Item("Apple", 15)); // Replaces "Apple" with value 10
        collection.add(new Item("Orange", 25));
        collection.add(new Item("Banana", 18)); // Not added (existing "Banana" is better)
        collection.add(new Item("Pineapple", 30)); // Adds and removes the smallest

        List<Item> topItems = collection.getElements();
        System.out.println("Top Items: " + topItems);
    }
}
