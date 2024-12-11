package io.nishandi.javapractice;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime lastModifiedTime;

    public Person(String firstName, String lastName, int age, LocalDateTime lastModifiedTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }

        if (o == null){
            return false;
        }

        if (this.getClass() != o.getClass()){
            return false;
        }

        Person p = (Person) o;

        return this.age == p.getAge()
                && this.firstName == p.getFirstName()
                && this.lastName == p.getLastName();
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName, lastName, age);
    }

    public static class Solution {
        public static void main(String[] args) {
            Person p1 = new Person("Foo", "Bar", 31, LocalDateTime.now());
            Person p2 = new Person("Foo", "Bar", 31, LocalDateTime.now());
    
            System.out.println(p1.equals(p2));
    
        }
    }
}

