package org.example;

public class Student {
    private int age;
    private Writer write;

    public Student(int age,Writer write) {
        this.age=age;
        this.write = write;
    }

    public Writer getWrite() {
        return write;
    }

    public void setWrite(Writer write) {
        this.write = write;
    }

    public Student()
    {
     System.out.println("The Object is created");
    }
    public void show()
    {
        System.out.println("Student details");
    }

    public void writing()
    {
        write.write();
    }
}
