package com.tj.ex08_super;
public class Person {
	private String name;
	private String character;
	public Person() {
		System.out.println("매개변수=파라미터=인자가 없는 Person");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("매개변수 2개짜리 Person");
	}
	public void intro() {
		System.out.println(name+"는 "+character);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
