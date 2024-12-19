package io.nishandi.javapractice;

import java.util.*;

public class CollectionExercise {
    public static void main(String[] args) {
        Person p1 = new Person("nitin",32);
        Person p2 = new Person("nitin",32);
        System.out.println(p1.equals(p2));

        Person p3 = new Person("apple",24);
        Person p4 = new Person("ball",23);
        Person p5 = new Person("cat", 21);

        //pre created comparator
        List<Person> personCollection = Arrays.asList(p3,p4,p5);
        Collections.sort(personCollection, new NameComparator());
        System.out.println(personCollection);
        Collections.sort(personCollection, new AgeComparator());

        //Supplying comparator at runtime
        Collections.sort(personCollection, Comparator.comparing(Person::getAge));
        System.out.print(personCollection);

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class  AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
