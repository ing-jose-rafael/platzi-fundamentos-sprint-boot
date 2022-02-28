package com.fundamentosplatzi.sprintboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;
    // para ir mostrando mensaje en nuestro servidor
    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }


    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos entrado a la clase printWithDependency");
        int numero = 4;
//        normalmente el nivel de debug cuando montamos en un servidor la aplicacion esta apagado
        LOGGER.debug("el numero que hemos pasado como parametro  a la dependencia operacion es: "+numero);
        System.out.println(myOperation.suma1(numero));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
