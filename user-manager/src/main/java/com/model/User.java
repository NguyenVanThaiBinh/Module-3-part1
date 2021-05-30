package com.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name,email,country;

    public int getId() {
        return id;
    }

    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }
    public User( String name, String email, String country) {

        this.name = name;
        this.email = email;
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User() {
    }
}
