package com.fundamentosplatzi.sprintboot.fundamentos.configuration;

import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.sprintboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    /* Obteniendo el valor de la propiedad que esta en resources/application.application */
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name,apellido);
    }
}
