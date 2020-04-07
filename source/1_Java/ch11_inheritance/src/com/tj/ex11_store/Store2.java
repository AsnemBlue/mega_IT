package com.tj.ex11_store;
//김치찌개-5,000  부대찌개-5,000(바)  비빔밥-5,000(바) 순대국-5,000  공기밥-무료(바)
public class Store2 extends HeadQuarterStore{
	private String str = "대학가 2호점";
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 5,000원");
	}
	@Override
	public void gongibab() {
		System.out.println("공기밥 무료");
	}
	@Override
	public String getStr() {
		return str;
	}
}
