package com.tj.ch17_1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch17_1.dto.Emp;
import com.tj.ch17_1.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService eService;
	@RequestMapping(value="emp", method = RequestMethod.GET)
	public String emp(@ModelAttribute("searchEmp") Emp searchEmp, Model model) {
		model.addAttribute("empList", eService.empList(searchEmp));
		model.addAttribute("deptList", eService.deptList());
		return "emp";
	}
}