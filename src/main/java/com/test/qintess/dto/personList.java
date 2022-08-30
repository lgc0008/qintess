package com.test.qintess.dto;

import lombok.Getter;
import lombok.Setter;

public class personList {

    private int age;
    private String name;

    public personList(final int age, final String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
