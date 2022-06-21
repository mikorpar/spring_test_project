package com.ibm.test.first_project.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomModelMapper extends ModelMapper {

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(elem -> this.map(elem, targetClass))
                .collect(Collectors.toList());
    }
}
