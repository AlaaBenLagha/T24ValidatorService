//package com.pfe.tools;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Converter
//public class ListStringConverter implements AttributeConverter<List<Integer>, String> {
//    private static final String SPLIT_CHAR = ";"; 
//
//    @Override
//    public String convertToDatabaseColumn(List<Integer> list) {
//        return list != null ? String.join(SPLIT_CHAR, list.stream().map(Object::toString).collect(Collectors.toList())) : "";
//    }
//
//    @Override
//    public List<Integer> convertToEntityAttribute(String joined) {
//        return joined != null ? Arrays.stream(joined.split(SPLIT_CHAR)).map(Integer::valueOf).collect(Collectors.toList()) : null;
//    }
//}
//
