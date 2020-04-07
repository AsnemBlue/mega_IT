package com.tj.ch09.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	@RequestMapping(value="/")
	public String home(Model model) {
		model.addAttribute("greeting", "안녕하세요. 금요일입니다. 와우");
		return "main";
	}
}
