package com.tj.ex4_man;
public class Man {
	private int age;
	private int height;
	private int weight;
	private String phoneNum;   // 010-9999-9999    01099999999 둘다 숫자가 아닌 스트링
	public Man() {System.out.println("매개변수 없는 생성자 호출됨");} // 디폴트 생성자 Man man = new Man()
	public Man(int age, int height, int weight, String phoneNum) {// Man man = new Man(25, 165, 65, "010-9999-9999");
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
	}
	public Man(int height, int weight) {// Man man = new Man(165,65)
		this.height = height;
		this.weight = weight;
	}
	public Man(int height) {// Man man = new Man(165)
		this.height = height;
	}
	public Man(double weight) {// Man man = new Man(65.0)
		this.weight = (int)weight;
	}
	public double calculateBMI() {
		double result = weight / ((height*0.01)*(height*0.01)); // 계산된 bmi 지수
		return result;
	}
	// age, height, weight, phoneNum의 getter와 setter
	public void setAge(int age) {this.age = age;	}
	public int getAge() {return age;	}
	public void setHeight(int height) {this.height = height;}
	public int getHeight() {return height;}
	public void setWeight(int weight) {this.weight = weight;}
	public int getWeight() {return weight;	}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getPhoneNum() {return phoneNum;}
}











