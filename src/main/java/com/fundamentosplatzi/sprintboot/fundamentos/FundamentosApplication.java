package com.fundamentosplatzi.sprintboot.fundamentos;

import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.sprintboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.sprintboot.fundamentos.component.ComponentDependecy;
import com.fundamentosplatzi.sprintboot.fundamentos.entity.User;
import com.fundamentosplatzi.sprintboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.sprintboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependecy componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
//	mostrando un error
	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private final UserRepository userRepository;// inyentando el repositorio de usuario

	public FundamentosApplication(@Qualifier("complementTwoImplement") ComponentDependecy componentDependecy, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriore();
		saveUsersInDataBase();

	}
	private void ejemplosAnteriore(){
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
	/* Metodo para persistir guardar en la DB*/
	private void saveUsersInDataBase(){
		User user1 = new User("Emiliano1","emiliano1@test.com", LocalDate.of(2022,9,27));
		User user2 = new User("Karen","karen@test.com", LocalDate.of(2022,3,02));
		User user3 = new User("Jose","jose@test.com", LocalDate.of(2021,12,24));
		User user4 = new User("Guille","guille@test.com", LocalDate.of(2022,4,24));
		User user5 = new User("luzmy","luzmy@test.com", LocalDate.of(2020,3,02));
		User user6 = new User("yulis","yulis@test.com", LocalDate.of(2021,7,14));
		User user7 = new User("Jhon","jhon@test.com", LocalDate.of(2021,9,12));
		User user8 = new User("Adriana","Adriana@test.com", LocalDate.of(2022,12,02));
		User user9 = new User("User9","user9@test.com", LocalDate.of(2021,11,22));
		User user10 = new User("Yohandris","yohandris@test.com", LocalDate.of(2021,3,10));
		User user11 = new User("daris","daris@test.com", LocalDate.of(2021,8,22));

		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11);
		// recorriendo la lista y guardando
		userList.forEach(userRepository::save);
//		userRepository.save(user1);
	}
}
