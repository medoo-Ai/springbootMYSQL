package com.demo.spring.constact;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther SyntacticSugar
 * @data 2019/3/28 0028下午 11:51
 */
public enum SexEnum {
    MAN(1,"男"),
    WOMAN(2,"女");
    private int id ;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name= name;
    }

    public static SexEnum getEnumById(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
