package com.fundamentosplatzi.sprintboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComplementTwoImplement implements ComponentDependecy{
    @Override
    public void saludar() {
        System.out.println("Saludando desde el segundo componente ");
    }
}
