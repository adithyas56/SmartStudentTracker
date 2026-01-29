package com.project.model;

public class Student {

    private String name;
    private String department;
    private int year;

    public Student(String name, String department, int year) {
        this.name = name;
        this.department = department;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }
}
