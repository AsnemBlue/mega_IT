package com.tj.ex10_customer;

import com.tj.cons.Constant;

public class Customer extends Person {
	private String add;
	private int sum;   // 구매누적금액
	private int point; // 포인트(구매할 때마다 5%적립)
	private String date; // 기념일
	private boolean vip; // true면 vip고객, false면 일반고객
	// Customer c = new Customer("홍","9999-9999","서울","0811");
	public Customer(String name, String tel, String add, String date) {
		// 반드시 super단의 생성자 호출은 첫번째 라인에
		super(name, tel);
		this.add = add;
		this.date = date;
		sum = 0; // 새로운 고객은 구매누적금액 0원으로
		point = 1000; // 회원가입한 첫고객은 1000점 포인트 자동 부여
		vip = false;  // 새로운 고객은 일반고객으로 자동 분류		
		System.out.println(name+"님 감사감사 어서오세요 포인트 1000점을 선물로");
	}
	public void buy(int price) { // c.buy(10000);
		sum += price;
		int tempPoint = (int)(price*Constant.RATE);
		point += tempPoint;
		System.out.println(getName()+"님 감사 금번포인트:"+tempPoint+", 총포인트:"+point);
		if(sum>1000000 && vip==false) {
			vip = true; // 누적금액이 100만원 초과시 vip고객으로 
		}//if
	}//buy
	@Override
	public String infoString() {//[이름]홍길동 [전화]9999-9999 [주소]서울종로 [포인트]500
		return super.infoString()+" [주소]"+add +"[ 포인트]"+point;
	}
}

















