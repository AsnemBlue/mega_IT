package com.tj.ch18_sch.service;
import java.util.List;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.ch18_sch.dto.Book;
public interface BookService {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public Book getBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	//public int registerBook(MultipartHttpServletRequest mRequest); 위나 아래 둘중에 하나
	//public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	public int modifyBook(MultipartHttpServletRequest mRequest);
	public int cntBook(Book book);
}
