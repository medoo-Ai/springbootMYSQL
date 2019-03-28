package com.demo.spring.bean;

import com.demo.spring.constact.SexEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther SyntacticSugar
 * @data 2019/3/27 0027下午 11:42
 */

@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private int age;
    private SexEnum sexEnum;
}
