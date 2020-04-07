package com.tj.ex6_homework;

public class SalaryEmployee extends Employee {
	private int annalSalary;
	public SalaryEmployee() { }
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	@Override
	public int computePay() {
		return annalSalary / 14;
	}
	public int getAnnalSalary() {
		return annalSalary;
	}
	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}
}