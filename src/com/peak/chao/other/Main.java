package com.peak.chao.other;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TestModel testModel = new TestModel();
        System.err.println(testModel.toString());
        Field field = testModel.getClass().getDeclaredField("age");
        field.setAccessible(true);
        Field name = testModel.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(testModel, "Mr-Zhang");
        System.err.println(field.get(testModel));
        field.set(testModel, 19);
        System.err.println(field.get(testModel));
        System.err.println(testModel.toString());
    }
}
