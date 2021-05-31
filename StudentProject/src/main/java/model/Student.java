package model;

import java.io.Serializable;

public class Student  implements Serializable {
    private String name, address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, int age,String name, String email ) {
        this.name = name;
        this.address = email;
        this.id = id;
        this.age = age;
    }

    public Student() {
    }

    private int id, age;
}
