package model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int staffID, phone, cmnd;

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Staff(int staffID,String group,String name, String dob,String gender,int phone, int cmnd,     String email, String address) {
        this.staffID = staffID;
        this.phone = phone;
        this.cmnd = cmnd;
        this.group = group;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
    }
    public Staff(String group,String name, String dob,String gender,int phone, int cmnd,     String email, String address) {

        this.phone = phone;
        this.cmnd = cmnd;
        this.group = group;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
    }

    //     users.add(new Staff(id,groupby, name, gender, phone));
    public Staff(int staffID, String group, String name, String gender, int phone) {
        this.staffID = staffID;
        this.phone = phone;

        this.group = group;
        this.name = name;

        this.gender = gender;


    }

    public Staff() {
    }

    private String group, name, dob, gender, email, address;
}
