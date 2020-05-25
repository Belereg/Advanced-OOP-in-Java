package com.company.model;

public class Client {
    private Integer id;
    private Short age;
    private String name;

    public Client() {
        this.age = 0;
        this.name = "not defined";
        this.id = 0;
    }

    public Client(Integer id, Short age, String name) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
