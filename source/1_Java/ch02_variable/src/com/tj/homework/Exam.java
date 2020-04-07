package com.tj.homework;
// ±¹, ¿µ, ¼ö, ÃÑÁ¡, Æò±Õ
public class Exam {
	public static void main(String[] args) {
		int kor = 100;
		int eng = 99;
		int mat = 100;
		int tot = kor + eng + mat; // ÃÑÁ¡
//		double avg = (double)tot / 3;
		double avg = tot / 3.0;
		System.out.println("±¹¾î : "+kor+"\t¿µ¾î : "+eng+"\t¼öÇÐ : "+mat);
		System.out.printf("ÃÑÁ¡ : %d\tÆò±Õ : %.2f\n", tot, avg);		
	}
}
