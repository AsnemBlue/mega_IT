package com.tj.ch18_sch.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18_sch.dto.Member;
import com.tj.ch18_sch.service.MemberService;
@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(params="method=joinForm", method=RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping(params="method=idConfirm", method=RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		int result = memberService.idConfirm(mid);
		model.addAttribute("result", result);
		return "member/idConfirm";
	}
	@RequestMapping(params="method=join", method=RequestMethod.POST)
	public String join(Member member, HttpSession httpSession) {
		memberService.joinMember(member, httpSession);
		return "redirect:member.do?method=loginForm";
	}
	@RequestMapping(params="method=loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login", method=RequestMethod.POST)
	public String login(String mid, String mpw, Model model,HttpSession httpSession) {
		String result = memberService.loginCheck(mid, mpw, httpSession);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm() {
		return "member/modifyForm";
	}
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modify(Member member, Model model, HttpSession httpSession) {
		int result = memberService.modifyMember(member);
		if(result==1) {//수정성공
			httpSession.setAttribute("member", member);
			model.addAttribute("modifyResult", result);
			return "forward:main.do";
		}else { // 수정실패
			return "forward:member.do?method=modifyForm";
		}
	}
	@RequestMapping(params="method=logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}
}
