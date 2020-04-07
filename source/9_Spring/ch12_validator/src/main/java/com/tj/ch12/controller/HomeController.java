package com.tj.ch12.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch12.dto.Student;
import com.tj.ch12.dto.StudentValidator;
@Controller
public class HomeController {
	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	@RequestMapping(value="input", method = RequestMethod.POST)
	public String input(@Validated Student student, BindingResult errors, Model model) {
		//StudentValidator validator = new StudentValidator();
		//validator.validate(student, errors); // 검증해
		if(errors.hasErrors()) {
			if(errors.getFieldError("name")!=null) {
				model.addAttribute("nameError","name은 반드시 입력요망");
			}
			if(errors.getFieldError("id")!=null) {
				model.addAttribute("idError","id는 자연수로 입력요망");
			}
			return "inputForm";
		}
		return "inputResult";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}





