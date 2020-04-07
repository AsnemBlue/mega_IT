package com.tj.ex1_store;
//본사 : 김치찌개-0 부대찌개-0  비빔밥-0 순대국-0  공기밥-0
public abstract class HeadQuarterStore {
	private String str = "본사";
	public abstract void kimchi(); // 추상메소드 : 선언부만 있는 메소드(구현부는 없음)
	public abstract void bude() ;
	public abstract void bibib() ;
	public abstract void sunde() ;
	public abstract void gongibab() ;
	public String getStr() {return str;}
}
