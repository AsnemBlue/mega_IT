package com.tj.ch09.dto;

public class Member {
	private String id;
	private String pw;
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
}
