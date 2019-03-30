package com.demo.spring.bean;

import com.demo.spring.constact.SexEnum;
import com.demo.spring.converter.SexEnumConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @auther SyntacticSugar
 * @data 2019/3/27 0027下午 11:42
 */

@Getter
@Setter
@ToString
@Entity(name = "user")
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Convert(converter = SexEnumConverter.class )
    private SexEnum sexEnum;
}
