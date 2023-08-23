package com.example.writeagain.vo;

public class CourseCountOfSubject {
    private int Value;
    private String name;


    @Override
    public String toString() {
        return "CourseCountOfSubject{" +
                "Value=" + Value +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
}
