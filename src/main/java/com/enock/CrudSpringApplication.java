package com.enock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.enock.model.Example;
import com.enock.respository.ExampleRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	
	@Bean
	 CommandLineRunner commandLineRunner(ExampleRepository exampleRepository){
        return args -> {
            Example example = new Example();
            example.setPosition("SF");
            example.setName("LeBron James");
            example.setPpg("25");
            exampleRepository.save(example);
        };
    }
}
