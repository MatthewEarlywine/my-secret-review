package com.liftoff.mysecretreview.models;

public class User extends AbstractEntity{

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String  toString() {
        return "User{" +
                "userId=" + getId() +
                ", studentName='" + username + '\'' +
                '}';
    }
}
