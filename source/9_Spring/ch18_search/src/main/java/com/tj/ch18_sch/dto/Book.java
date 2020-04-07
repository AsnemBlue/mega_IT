package com.tj.ch18_sch.dto;
import java.sql.Date;
public class Book {
	private int bnum;      // 책번호
	private String btitle; // 책이름
	private String bwriter;// 책저자
	private Date   brdate; // 출판일
	private String bimg1;  // 책이미지1 (첨부안하면 noimg.jpg로 할 예정)
	private String bimg2;  // 책이미지2 (첨부안하면 noimg.jpg로 할 예정)
	private String binfo;  // 책소개
	private int startRow;
	private int endRow;
	private String schItem; // 검색하려고 선택된 항목 (책이름=btitle or 저자=bwriter)
	private String schWord; // 검색할 단어
	public int getBnum() {return bnum;}
	public void setBnum(int bnum) {this.bnum = bnum;}
	public String getBtitle() {return btitle;}
	public void setBtitle(String btitle) {this.btitle = btitle;}
	public String getBwriter() {return bwriter;}
	public void setBwriter(String bwriter) {this.bwriter = bwriter;}
	public Date getBrdate() {return brdate;}
	public void setBrdate(Date brdate) {this.brdate = brdate;}
	public String getBimg1() {return bimg1;}
	public void setBimg1(String bimg1) {this.bimg1 = bimg1;}
	public String getBimg2() {return bimg2;}
	public void setBimg2(String bimg2) {this.bimg2 = bimg2;}
	public String getBinfo() {return binfo;}
	public void setBinfo(String binfo) {this.binfo = binfo;}
	public int getStartRow() {return startRow;}
	public void setStartRow(int startRow) {this.startRow = startRow;}
	public int getEndRow() {return endRow;}
	public void setEndRow(int endRow) {this.endRow = endRow;}
	public String getSchItem() {
		return schItem;
	}
	public void setSchItem(String schItem) {
		this.schItem = schItem;
	}
	public String getSchWord() {
		return schWord;
	}
	public void setSchWord(String schWord) {
		this.schWord = schWord;
	}
	@Override
	public String toString() {
		return "Book [bnum=" + bnum + ", btitle=" + btitle + ", bwriter=" + bwriter + ", brdate=" + brdate + ", bimg1="
				+ bimg1 + ", bimg2=" + bimg2 + ", binfo=" + binfo + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", schItem=" + schItem + ", schWord=" + schWord + "]";
	}
}
