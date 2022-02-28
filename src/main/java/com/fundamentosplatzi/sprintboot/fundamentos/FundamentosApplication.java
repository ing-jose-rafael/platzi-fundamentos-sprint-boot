package com.fundamentosplatzi.sprintboot.fundamentos;

import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.sprintboot.fundamentos.component.ComponentDependecy;
import com.fundamentosplatzi.sprintboot.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
//	mostrando un error
	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	public FundamentosApplication(@Qualifier("complementTwoImplement") ComponentDependecy componentDependecy, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,UserPojo userPojo) {
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println("el email del usuario es "+userPojo.getEmail());
		try {
			int value = 10/0;
			LOGGER.debug("El valor de la variables es "+value);
		}catch (Exception e) {
			// mostrando el error en el servidor
			LOGGER.error("Esto es un error al dividir por cero "+ e.getMessage());
		}

	}
}
