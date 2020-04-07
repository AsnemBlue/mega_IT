package com.tj.ch09.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="member")
public class MemberController {
	@RequestMapping(params="method=join")
	public String member(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	@RequestMapping(params="method=login")
	public String login() {
		return "member/login";
	}
	@RequestMapping(params="method=logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "로그아웃되었습니다");
		mav.setViewName("member/logout");
		return mav;
	}
	@RequestMapping(params="method=modify")
	public ModelAndView modify(ModelAndView mav) {
		mav.addObject("msg", "정보수정입니다");
		mav.setViewName("member/modify");
		return mav;
	}
}









