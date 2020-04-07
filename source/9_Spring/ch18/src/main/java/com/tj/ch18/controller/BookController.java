package com.tj.ch18.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18.dto.Book;
import com.tj.ch18.service.BookService;
import com.tj.ch18.util.Paging;
@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(params="method=registerForm", method=RequestMethod.GET)
	public String registerForm() {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, Book book, Model model) {
		bookService.registerBook(mRequest, book);
		return "book/registerForm";
	}
	@RequestMapping(params="method=list")
	public String view(Book book, String pageNum, Model model) {
		Paging paging = new Paging(bookService.cntBook(), pageNum, 3, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		model.addAttribute("list", bookService.bookList(book));
		model.addAttribute("paging", paging);
		return "book/list";
	}
	@RequestMapping(params="method=detail", method = RequestMethod.GET)
	public String detail(int bnum, Model model) {
		model.addAttribute("detail", bookService.getBook(bnum));
		return "book/detail";
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(int bnum, String pageNum, Model model) {
		model.addAttribute("modify", bookService.getBook(bnum));
		return "book/modifyForm";
	}
	@RequestMapping(params="method=modify", method = RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, String pageNum) {
		bookService.modifyBook(mRequest);
		return "redirect:book.do?method=list&pageNum="+pageNum;
	}
}
