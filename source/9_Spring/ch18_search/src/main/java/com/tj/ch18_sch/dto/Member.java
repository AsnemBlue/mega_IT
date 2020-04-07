package com.tj.ch18_sch.dto;

public class Member {
	private String mid;
	private String mpw;
	private String mname;
	private String mmail; //메일
	private String maddr; //주소
	private String mpost; //우편번호
	public String getMid() {return mid;}
	public void setMid(String mid) {this.mid = mid;}
	public String getMpw() {return mpw;}
	public void setMpw(String mpw) {this.mpw = mpw;}
	public String getMname() {return mname;}
	public void setMname(String mname) {this.mname = mname;}
	public String getMmail() {return mmail;}
	public void setMmail(String mmail) {this.mmail = mmail;}
	public String getMaddr() {return maddr;}
	public void setMaddr(String maddr) {this.maddr = maddr;}
	public String getMpost() {return mpost;}
	public void setMpost(String mpost) {this.mpost = mpost;}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mmail=" + mmail + ", maddr=" + maddr
				+ ", mpost=" + mpost + "]";
	}
}
