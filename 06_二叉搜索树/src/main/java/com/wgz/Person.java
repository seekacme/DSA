package com.wgz;

public class Person implements Comparable<Person> {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int compareTo(Person person) {
        return this.age - person.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person_age="+this.age;
    }
}
