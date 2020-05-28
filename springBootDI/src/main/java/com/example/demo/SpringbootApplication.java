package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringbootApplication.class, args);
		System.out.print("hello.......");
		
		Student s=context.getBean(Student.class);
		
		s.setId(1);
		s.setMarks(100);
		s.setName("Aman");
		System.out.println(s.getId()+" "+s.getMarks()+" "+s.getName());
		
	     s.show();
	}
}