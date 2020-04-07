package com.tj.ex11_store;
//김치찌개-5,000(그)  부대찌개-5,000(바)  비빔밥-6,000(그) 순대국-안팔아(바) 공기밥-1,000원(그)
public class Store1 extends HeadQuarterStore{
	private String str = "주택가1호점";
	@Override
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 안팔아");
	}
	@Override
	public String getStr() {
		return str;
	}
}
