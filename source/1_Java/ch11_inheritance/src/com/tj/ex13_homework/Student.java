package com.tj.ex13_homework;

public class Student extends Person{
	private String ban;
	public Student() { }
	public Student(String id, String name, String ban){
		super(id,name);
		this.ban = ban;
	}
	@Override
	public String infoString() {
		return super.infoString()+"\t(¹Ý)"+ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+ban);
	}
}
