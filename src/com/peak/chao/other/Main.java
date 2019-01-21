package com.peak.chao.other;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TestModel testModel = new TestModel();
        Field field = testModel.getClass().getDeclaredField("age");
        field.setAccessible(true);
        System.err.println(field.get(testModel));
        field.set(testModel, 19);
        System.err.println(field.get(testModel));
    }
}
