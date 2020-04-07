package com.tj.ex01_store;
//±èÄ¡Âî°³-5,000  ºÎ´ëÂî°³-5,000(¹Ù)  ºñºö¹ä-5,000(¹Ù) ¼ø´ë±¹-5,000  °ø±â¹ä-¹«·á(¹Ù)
public class Store2 implements HeadQuarterStore{
	private String str = "´ëÇĞ°¡ 2È£Á¡";
	@Override
	public void kimchi() {System.out.println("±èÄ¡Âî°³ 5,000¿ø");}
	@Override
	public void bude() {System.out.println("ºÎ´ëÂî°³ 5,000¿ø");}
	@Override
	public void bibib() {System.out.println("ºñºö¹ä 5,000¿ø");}
	@Override
	public void sunde() {System.out.println("¼ø´ë±¹ 5,000¿ø");}
	@Override
	public void gongibab() {System.out.println("°ø±â¹ä ¹«·á");}
	public String getStr() {
		return str;
	}
}
