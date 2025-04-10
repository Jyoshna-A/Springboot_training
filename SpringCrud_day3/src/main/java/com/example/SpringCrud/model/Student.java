package com.example.SpringCrud.model;

public class Student {
    private int age;
    private int roll;
    private String name;

    public Student() {}

    public Student(int age, int roll, String name) {
        this.age = age;
        this.roll = roll;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
