package com.tj.ex5_pouch;
public class PouchTestMain {
	public static void main(String[] args) {
		System.out.println("¾ö¸¶ Áö°© µ· : "+MomPouch.money);
		Child first  = new Child("Ã¹Â°±æµ¿ÀÌ");
		Child second = new Child("µÑÂ°¶Ê¸¸ÀÌ");
		Child third  = new Child("¼ÂÂ°¶ÊÈÆÀÌ");
		first.takeMoney(100);
		System.out.println("¾ö¸¶ Áö°© µ· : "+MomPouch.money);
		second.takeMoney(100);
		third.takeMoney(100);
		System.out.println("¾ö¸¶ Áö°© µ· : "+MomPouch.money);
	}
}
