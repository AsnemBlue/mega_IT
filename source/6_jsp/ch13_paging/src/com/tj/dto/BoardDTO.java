package com.tj.dto;

import java.sql.Timestamp;

public class BoardDTO {
/*
 * NUM         NUMBER(5) PRIMARY KEY,      -- 글번호
    WRITER      VARCHAR2(30)    NOT NULL,   -- 글쓴이
    SUBJECT     VARCHAR2(100)   NOT NULL,   -- 글제목
    CONTENT     VARCHAR2(1000)  NOT NULL,   -- 글본문
    EMAIL       VARCHAR2(30),               -- 작성자 메일주소
    HIT         NUMBER(5)       DEFAULT 0,  -- 조회수
    PW          VARCHAR2(30)    NOT NULL,   -- 글삭제시 쓸 비밀번호
    REF         NUMBER(5)       NOT NULL,   -- 글그룹
    RE_STEP    NUMBER(5)       NOT NULL,       -- 같은 글 그룹끼리 출력 순서(원글:0)
    RE_LEVEL    NUMBER(5)       NOT NULL,       -- 답변글일 경우 들여쓰기 정도(원글:0)
    IP          VARCHAR2(20)    NOT NULL,   -- 작성자의 컴퓨터 IP주소
    RDATE       DATE            DEFAULT SYSDATE    -- 글쓴 시점(날짜 + 시간)
 * */
	private int 		num;
	private String 		writer;
	private String 		subject;
	private String 		content;
	private String 		email;
	private int 		hit;
	private String 		pw;
	private int 		ref;
	private int 		re_step;
	private int 		re_level;
	private String 		ip;
	private Timestamp 	rDate;
	
	public BoardDTO() {}
	
	public BoardDTO(int num, String writer, String subject, String content, String email, int hit, String pw, int ref,
			int re_step, int re_level, String ip, Timestamp rDate) {
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.email = email;
		this.hit = hit;
		this.pw = pw;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.ip = ip;
		this.rDate = rDate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", email=" + email + ", hit=" + hit + ", pw=" + pw + ", ref=" + ref + ", re_step=" + re_step
				+ ", re_level=" + re_level + ", ip=" + ip + ", rDate=" + rDate + "]";
	}
}
