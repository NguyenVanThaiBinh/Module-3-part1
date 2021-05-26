package com.example.JSP_part_1;

import java.io.Serializable;

public class Student implements Serializable {
     private String name,email,birthday,address;

    public String getName() {
        return name;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(String name, String email, String birthday, String address) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }
}
