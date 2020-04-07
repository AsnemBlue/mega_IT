package com.tj.ex3_math;
import java.util.Random;
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*45)+1);
		Random random = new Random();
		System.out.println("int 난수 : "+random.nextInt());
		System.out.println("double 난수 : "+random.nextDouble()); //Math.random() == random.nextDouble()
		System.out.println("T/F 난수 : "+random.nextBoolean());
		System.out.println("0~100까지 정수 난수 : " + random.nextInt(101));
		System.out.println("0~44까지 정수 난수 : " +random.nextInt(45));
		System.out.println("1~45까지 정수 난수 : "+ (random.nextInt(45)+1) );//
	}
}
