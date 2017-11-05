package de.bennypi.catfood;

import de.bennypi.catfood.actuator_connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatfoodApplication.class, args);
	}

	//@Autowired
    //Connector connector;

	@Bean
    public CommandLineRunner run(Connector connector){
		return args -> connector.deployFood();
	}
}
