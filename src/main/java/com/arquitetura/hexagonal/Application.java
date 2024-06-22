package com.arquitetura.hexagonal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//gradlew bootRun --args='create2 prod'
		SpringApplication.run(Application.class, args);
		if(args.length > 2 && args[1].equals("prod")){
			System.out.println("up prod ");
		}else {
			System.out.println("up dev");
		}
	}

}
