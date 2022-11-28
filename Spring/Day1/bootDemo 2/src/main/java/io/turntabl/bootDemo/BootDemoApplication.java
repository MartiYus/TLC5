package io.turntabl.bootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemoApplication implements CommandLineRunner {

	@Autowired
	Owner o;

	@Autowired
	Cat c;

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world from Spring Boot!");

		//Owner o1 = new Owner("Martina", cat);
		//o1.makePetTalk();

		o.setCat(c);
		o.makePetTalk();

	}
}
