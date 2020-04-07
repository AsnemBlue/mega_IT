package com.tj.ch08;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	// "/" - > 무슨일 수행 -> "home.jsp" 뷰단으로 이동
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("greeting", "안녕하세요. 스프링 MVC");
		return "home";
	}
	@RequestMapping("main")
	public String main() {
		return "main/main";
	}
}
