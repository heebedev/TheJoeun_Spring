package com.springlec.spring0306;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String configLocation1 = "classpath:appCTX.xml";
		String configLocation2 = "classpath:appCTX1.xml";

		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		System.out.println(student1.getHobbies());
		System.out.println(student1.getWeight());
		System.out.println(student1.getHeight());
		System.out.println("--------------------------");
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getHobbies());
		System.out.println(student2.getWeight());
		System.out.println(student2.getHeight());
		System.out.println("--------------------------");
		
		
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != studnet2");
		}
		
		ctx.close();
		
		
	}

}
