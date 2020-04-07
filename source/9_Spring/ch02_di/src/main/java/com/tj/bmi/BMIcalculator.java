package com.tj.bmi;
public class BMIcalculator {
	private double lowWeight; // 저체중 기준 bmi
	private double normal;    // 정상
	private double overWeight;// 과체중 기준
	private double obesity;   // 비만 기준
	public void bmiCal(double weight, double height) {
		// 180 / 63 bmi = 63/(1.8*1.8)
		double result = weight / (height*0.01*height*0.01);
		if(result>obesity) {
			System.out.println("비만입니다");
		}else if(result>overWeight) {
			System.out.println("과체중입니다");
		}else if(result>normal) {
			System.out.println("정상입니다");
		}else if(result>lowWeight) {
			System.out.println("저체중입니다");
		}else {
			System.out.println("심각한 저체중입니다");
		}
	}
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
}
