package com.company.model;

import java.util.Date;

public class User {

    public User() {
    }

    public User(String email, String name, Date registeredDateTime) {
        this.email = email;
        this.name = name;
        this.registeredDateTime = registeredDateTime;
    }

    private String email;

    private String name;

    private Date registeredDateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisteredDateTime() {
        return registeredDateTime;
    }

    public void setRegisteredDateTime(Date registeredDateTime) {
        this.registeredDateTime = registeredDateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", registeredDateTime=" + registeredDateTime +
                '}';
    }
}
