package com.vstepura.web;

public class Person {

//    private static int id = 0;
    private String firstName;
    private String secondName;
    private String sex;

    public Person() {
        firstName = "default";
        secondName = "default";
        sex = "default";
    }

    public Person(String firstName, String secondName, String sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
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
