package com.tj.ex2_parking;

import com.tj.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
	//private static final int HOURLYPARKINGRATE = 2000; // final 변수 = 상수
	// Parking car1 = new Parking("11루1111",12);
	public Parking(String no, int inTime) {
		this.no = no; this.inTime = inTime;
		System.out.println(no+"님 어서오세요");
		System.out.println("입차시간 : "+inTime+"시");
	}
	// car1.out(14);
	public void out(int outTime) {
		this.outTime = outTime;
		fee = (outTime-inTime) * PiClass.HOURLYPARKINGRATE;
		System.out.println(no+"님 안녕히 가세요");
		System.out.println("입차시간 : "+ inTime +"시");
		System.out.println("출차시간 : "+ outTime +"시");
		System.out.println("주차요금 : "+fee+"원");
	}
}










