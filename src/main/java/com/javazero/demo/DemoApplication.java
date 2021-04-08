package com.javazero.demo;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	SeedData seedData;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		try {
			seedData.seedRole();
			seedData.seedCategory();
			seedData.seedUser();
			seedData.seedPost();

		} catch (HibernateException e) {
			System.out.println("Seed Data ERORR" + e);
		}

	}

}
