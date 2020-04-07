package com.tj.ex13_homework;

public class Staff extends Person {
	private String subject;
	public Staff() { }
	public Staff(String id, String name, String subject){
		super(id,name);
		this.subject = subject;
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(과목)"+subject;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(과목)"+subject);
	}
}
