package com.springlec.spring0308;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	@Bean
	public Student student1() {
		
		ArrayList<String> hobbies = new ArrayList<String>();
		
		hobbies.add("검도");
		hobbies.add("유도");
		
		Student student = new Student("장비", 20, hobbies);
		student.setHeight(180);
		student.setWeight(80);
		
		
		
		return student;
		
	}
	
	
//	@Bean
//	public Student student2() {
//		
//		ArrayList<String> hobbies = new ArrayList<String>();
//		
//		hobbies.add("태권도");
//		hobbies.add("권투");
//		
//		Student student = new Student("관우", 21, hobbies);
//		student.setHeight(180);
//		student.setWeight(70);
//		
//		
//		
//		return student;
//		
//	}

}
