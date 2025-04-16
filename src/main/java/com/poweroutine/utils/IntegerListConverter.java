package com.poweroutine.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> attribute) {
        return attribute != null ? attribute.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) : null;
    }

    @Override
    public List<Integer> convertToEntityAttribute(String dbData) {
        if (dbData != null && !dbData.isEmpty()) {
            // Elimina las llaves `{}` si están presentes
            dbData = dbData.replace("{", "").replace("}", "");
            return Arrays.stream(dbData.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        }
        return null;
    }
}