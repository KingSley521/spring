package com.example.demo.bean;

import com.example.demo.annotation.DemoAnnotation;
import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

