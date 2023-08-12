package com.foo.s01.javaBeans;

public class User {
    public long id;
    public String name;
    public School school;

    public User(int i, String string, School school2) {
        id = i;
        name = string;
        school = school2;
    }
}
