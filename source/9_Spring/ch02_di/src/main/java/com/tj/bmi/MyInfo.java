package com.tj.bmi;
import java.util.ArrayList;
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbies;
	private BMIcalculator bmiCalculator;
	private void bmiCalculation(){
		bmiCalculator.bmiCal(weight,height);
	}
	public void getInfo(){
		System.out.println("이름 : "+name);
		System.out.println("키 : "+height);
		System.out.println("몸무게 : "+weight);
		System.out.println("취미:"+ hobbies);
		bmiCalculation();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public void setBmiCalculator(BMIcalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
}
