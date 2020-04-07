package com.tj.ex12_book.cd;

public class BookInfo {
	private String bookNo;       // 책번호
	private String bookTitle;    // 책제목
	private String writer;       // 저자
	public BookInfo() { }
	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
