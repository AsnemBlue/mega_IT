package com.tj.ex13_homework;

public class Person {
	private String id;
	private String name;
	public Person() { }
	public Person(String id, String name){
		this.id = id;
		this.name = name;
	}
	public void print(){
		System.out.print("(ID)"+id+"\t(이름):"+name);
	}
	public String infoString() {
		return "(ID)"+id+"\t(이름):"+name;
	}
	public String getId() { return id; }
	public String getName() {return name;}
}
