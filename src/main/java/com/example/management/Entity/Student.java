package com.example.management.Entity;

import jakarta.persistence.*;

@Table(name="student_entity")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer sid;
    private String name;
    private Integer age;
    private char gender;
    public Student() {
    }

    public Student(Integer sid, String name, Integer age, char gender) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}


