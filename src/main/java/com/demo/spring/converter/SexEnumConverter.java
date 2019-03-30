package com.demo.spring.converter;

import com.demo.spring.constact.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * @auther SyntacticSugar
 * @data 2019/3/30 0030下午 12:38
 */
public class SexEnumConverter  implements AttributeConverter<SexEnum,Integer> {

    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer integer) {
        return SexEnum.getEnumById(integer);
    }
}
