package com.tj.ex2_date;
import java.util.GregorianCalendar;
public class Ex03_gc {
	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar();
		System.out.println("1970년 1월 1일 0시0분0초부터 지금까지의 밀리세컨은 다음과 같다");
		System.out.println(System.currentTimeMillis());
		System.out.println(gcNow.getTimeInMillis()); // 1970.1.1~gc시점까지의 밀리세컨
		GregorianCalendar gcThat = new GregorianCalendar(2019, 10, 25, 9, 30, 0);
		System.out.println(gcThat.getTimeInMillis()); // 1970~2019.11.25까지의 밀리세컨
	}
}
