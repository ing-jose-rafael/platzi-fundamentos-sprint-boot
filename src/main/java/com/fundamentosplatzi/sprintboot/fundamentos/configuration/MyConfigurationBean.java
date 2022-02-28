package com.fundamentosplatzi.sprintboot.fundamentos.configuration;

import com.fundamentosplatzi.sprintboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        /*return new MyBeanImplement();*/
        return new MyBeanTwoImplement();

    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImpl();
    }
    @Bean
    public MyBeanWithDependency  beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
