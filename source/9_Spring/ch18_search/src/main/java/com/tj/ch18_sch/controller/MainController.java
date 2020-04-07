package com.tj.ch18_sch.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj.ch18_sch.service.BookService;
@Controller
public class MainController {
	@Autowired
	private BookService bookService;
	// main.do는 GET방식과 POST방식이 모두 필요해서 method=RequestMethod.GET부분을 생략함.
	// 생략하면 GET방식과 POST방식 모두 사용 가능
	@RequestMapping(value="main")
	public String main(Model model) {
		model.addAttribute("main", bookService.mainList());
		return "main/main";
	}
}
