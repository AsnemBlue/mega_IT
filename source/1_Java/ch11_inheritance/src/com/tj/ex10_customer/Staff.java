package com.tj.ex10_customer;

public class Staff extends Person {
	private String hiredate;   // 입사일(2020-05-01) 다음주부터는 Date형
	private String department; //  부서
	// Staff s = new Staff("홍길동","9999-9999","2020-05-01","전산실");
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
		System.out.println("입사 축하축하");
	}
	// sysout(s.infoString()) -> [이름]홍길동 [전화]9999-9999 [부서]전산실
	@Override
	public String infoString() { 
		return super.infoString()+" [부서]"+department;
	}
}
