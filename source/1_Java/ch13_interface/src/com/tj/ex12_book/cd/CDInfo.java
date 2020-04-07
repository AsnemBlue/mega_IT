package com.tj.ex12_book.cd;

public class CDInfo {
	private String cdNo;
	private String cdTitle;
	private String bookNo;
	public CDInfo() { }
	public CDInfo(String cdNo, String cdTitle, String bookNo) {
		super();
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
		this.bookNo = bookNo;
	}
	public String getCdNo() {
		return cdNo;
	}
	public String getCdTitle() {
		return cdTitle;
	}
	public String getBookNo() {
		return bookNo;
	}
}