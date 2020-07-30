package com.springlec.spring0701;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);   //검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("validate()");
		
		Student student = (Student) target;
	
//		String studentName = student.getName();
//		
//		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("student is null or empty");
//			errors.rejectValue("name", "trouble");
//		}
		
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		
		
		int studentId = student.getId();
		
		if(studentId == 0) {   //숫자는 데이터가 안들어오면 0 값이다.
			System.out.println("student is 0");
			errors.rejectValue("id", "trouble");
		}
		
		
		
		
		
		
		
		
	}


} //StudentValidation
