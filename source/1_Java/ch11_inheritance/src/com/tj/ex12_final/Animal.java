package com.tj.ex12_final;
public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("¶Ù°í ÀÖ¾î¿ä. ÇöÀç¼Óµµ : "+speed);
	}
	public final void stop() { // stop() override ±İÁö
		speed = 0;
		System.out.println("¸ØÃã!");
	}
}
