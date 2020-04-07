package com.tj.ex0_janmuri;
class PersonInfo {
	private String name;
	private int age;
	private char gender;
	public PersonInfo() { }
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {//이름 = 홍길동	 나이 = 20	성별 = m 
		System.out.println("이름 = "+name+"\t나이 = "+age+"\t성별"+gender);
	}
}
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("홍길동", 20, 'm'),
							   new PersonInfo("홍길순",19,'f')
		};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
