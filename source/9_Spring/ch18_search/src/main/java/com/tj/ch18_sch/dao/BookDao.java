package com.tj.ch18_sch.dao;
import java.util.List;

import com.tj.ch18_sch.dto.Book;
public interface BookDao {
	public List<Book> mainList();
	public List<Book> bookList(Book book);
	public Book getBook(int bnum);
	public int registerBook(Book book);
	public int modifyBook(Book book);
	public int cntBook(Book book);
}