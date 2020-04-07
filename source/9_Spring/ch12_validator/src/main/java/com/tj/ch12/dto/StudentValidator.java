package com.tj.ch12.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class StudentValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz); // 검증할 객체를 명시
	}
	@Override //validator.validate(student, errors)
	public void validate(Object target, Errors errors) { // 검증하는 메소드
		String name = ((Student)target).getName();
		int id = ((Student)target).getId();
//		if(name == null || name.trim().isEmpty()) {
//			System.out.println("name이 비어서 검증 못 함");
//			errors.rejectValue("name", "no");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");
		if(id<=0) {
			System.out.println("id가 지연수가 아니라 reject");
			errors.rejectValue("id","no");
		}
	}
}








