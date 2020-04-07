package com.tj.ex12_final;

public class Dog extends Animal{
	@Override
	public void running() {
		speed += 10; // setSpeed(getSpeed()+10)
		System.out.println("¶Ù¸é¼­ ²¿¸®¸¦ Èçµé¾î¿ä. ÇöÀç ¼Óµµ : "+speed);
	}
}
