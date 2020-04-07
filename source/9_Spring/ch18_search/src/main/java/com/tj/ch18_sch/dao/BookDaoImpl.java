package com.tj.ch18_sch.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch18_sch.dto.Book;
@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Book> mainList() {
		return sessionTemplate.selectList("mainList");
	}
	@Override
	public List<Book> bookList(Book book) {
		return sessionTemplate.selectList("bookList", book);
	}
	@Override
	public Book getBook(int bnum) {
		return sessionTemplate.selectOne("getBook", bnum);
	}
	@Override
	public int registerBook(Book book) {
		return sessionTemplate.insert("registerBook", book);
	}
	@Override
	public int modifyBook(Book book) {
		return sessionTemplate.update("modifyBook", book);
	}
	@Override
	public int cntBook(Book book) {
		return sessionTemplate.selectOne("cntBook", book);
	}
}