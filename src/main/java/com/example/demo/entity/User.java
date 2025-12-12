package com.example.demo.entity;

public class User {

    private int id;
    private String userName;
    private String location;

    public User() {

    }

    public User(int id, String userName, String location) {
        this.id = id;
        this.userName = userName;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
