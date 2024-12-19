package io.nishandi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
Write code that calls the getFruits method and then iterates over the collection, printing each element to console
 */

public class IteratorExercise {

    public static void main(String[] args) {
        Collection<String> fruits = new FruitSupplier().getFruits();
        Iterator<String> fruitIterator = fruits.iterator();
        while (fruitIterator.hasNext())
            System.out.println("fruit = " + fruitIterator.next());

    }


}


class FruitSupplier {
    public Collection<String> getFruits() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        return list;
    }

}
