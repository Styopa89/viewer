package com.vstepura.web;

public class Person {

    private int id;
    private String firstName;
    private String secondName;
    private String sex;

    public Person() {
        id = 1;
        firstName = "default";
        secondName = "default";
        sex = "default";
    }

    public Person(int id, String firstName, String secondName, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
