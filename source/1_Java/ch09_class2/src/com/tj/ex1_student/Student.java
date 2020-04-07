package com.tj.ex1_student;
// 沥快己 90 90 90 270 90.0
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	// Student s = new Student("沥快己",90,90,90);
	public Student(String name, int kor, int eng, int mat) {
		this.name = name; this.kor = kor;
		this.eng = eng;   this.mat = mat;
		tot = kor+eng+mat;
		avg = tot/3.0;
	}
	// s.print() -> 沥快己 90 90 90 270 90.0 免仿
	public void print() {
		System.out.printf("\t %s \t %d \t %d \t %d \t %d \t %.1f\n",
				             name, kor, eng, mat, tot, avg);
	}
	// System.out.println(s.infoString());
	public String infoString() {
		String result = String.format("\t %s \t %d \t %d \t %d \t %d \t %.1f", 
				  						name, kor, eng, mat, tot, avg);
		return result;
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}










