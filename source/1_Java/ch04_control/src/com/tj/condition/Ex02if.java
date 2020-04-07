package com.tj.condition;

public class Ex02if {
	public static void main(String[] args) {
		int seoulLunchPrice = 4900;
		if(seoulLunchPrice >7000) {
			System.out.println("점심 밥값 비싸네요");
		}else if(seoulLunchPrice>=6000) {
			System.out.println("점심값 조금만 저렴했으면");
		}else if(seoulLunchPrice>=4000) {
			System.out.println("점심값 좋네요");
		}else {
			System.out.println("뭐 나는 좋은데 식당은 안 망하려나");
		}
	}
}
