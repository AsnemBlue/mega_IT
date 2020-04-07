package com.tj.ch15.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.tj.ch15.service.FileUploadService;
@Controller
public class FileController {
	@Autowired
	FileUploadService fService;
	@RequestMapping(value="fileInput", method = RequestMethod.GET)
	public String fileInput() {
		return "fileInput";
	}
	@RequestMapping(value="fileUpload", method = RequestMethod.POST)
	public ModelAndView fileupload(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		if(fService.FileUp(mRequest, mav)) {
			mav.addObject("fileResult","파일 업로드 성공");
		}else {
			mav.addObject("fileResult","파일 업로드 실패");
		}
		mav.setViewName("fileResult");
		return mav;
	}
}