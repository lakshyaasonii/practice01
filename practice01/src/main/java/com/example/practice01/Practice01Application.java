package com.example.practice01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Practice01Application {

	 public static void main(String[] args) {
		SpringApplication.run(Practice01Application.class, args);
	}

	@Bean
	public PlatformTransactionManager function(MongoDatabaseFactory dbfactory){
		 return new MongoTransactionManager(dbfactory);
	}

}
