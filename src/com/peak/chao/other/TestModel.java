package com.peak.chao.other;

public class TestModel {


    private final int age = 18;
    private final String name = new String("Mr");

    public TestModel() {
        //this.name = "Mr";
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}
