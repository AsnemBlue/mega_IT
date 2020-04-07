package com.tj.ex13_homework;

public class MainClass {
	public static void main(String[] args) {
		Person st1 = new Student("A01","강유미","JAVA반");
		Person st2 = new Student("A02","홍길동","C++반");
		Person sf1 = new Staff("S01","유길동","운영지원팀");
		Person sf2 = new Staff("S02","유만동","취업지원팀");
		Person ga1 = new Gangsa("G01","이길동","객체지향");
		Person[] person = {st1, st2, sf1, sf2, ga1};
		for(Person p : person)
			p.print();
	}
}
