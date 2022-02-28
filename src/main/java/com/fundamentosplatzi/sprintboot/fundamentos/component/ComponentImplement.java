package com.fundamentosplatzi.sprintboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependecy{
    @Override
    public void saludar() {
        System.out.println("Hola mundo saludando desde mi componente");
    }
}
