package com.fundamentosplatzi.sprintboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private final String name;
    private final String apellido;

    public MyBeanWithPropertiesImplement(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return this.name + " - " + this.apellido;
    }
}
