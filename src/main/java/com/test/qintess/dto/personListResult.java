package com.test.qintess.dto;

import lombok.Getter;
import lombok.Setter;

public class personListResult {

    @Getter
    @Setter

    private int age;

    public com.test.qintess.dto.personList getPersonList() {
        return personList;
    }

    private personList personList;

    public personListResult(int age, com.test.qintess.dto.personList personList) {
        this.age = age;
        this.personList = personList;
    }
}
