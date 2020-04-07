package com.tj.ch11hw;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch11hw.dto.Student;
@Controller
public class StudentController {
	@ModelAttribute("currentCnt")
	public int currentCnt() {
		return 4;
	}
	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String home() {
		return "inputForm";
	}
	@RequestMapping(value="input", method = RequestMethod.GET)
	public String input(Student student) {
		student.setSum(student.getKor()+student.getEng()+student.getMat());
		student.setAvg(Math.round(student.getSum()/3.0 * 100)/100.0);
		//student.setAvg(student.getSum()/3.0);
		return "inputResult";
	}
//	@RequestMapping(value="input", method = RequestMethod.GET)
//	public String input(String name, int kor, int eng, int mat, Model model) {
//		int sum = kor+eng+mat;
//		double avg = Math.round(sum/3.0*100)/100;
//		model.addAttribute("name", name);
//		model.addAttribute("kor", kor);
//		model.addAttribute("eng", eng);
//		model.addAttribute("mat", mat);
//		model.addAttribute("sum", sum);
//		model.addAttribute("avg", avg);
//		return "inputResult";
//	}
}
