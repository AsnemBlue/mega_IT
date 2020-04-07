package com.tj.ex2_date;
import java.util.Calendar;
public class Ex01_calender {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();  // 싱글톤 클래스 객체
		System.out.println(calendar);
		int year = calendar.get(Calendar.YEAR); // 년도
		int month = calendar.get(Calendar.MONTH)+1; // MONTH는 0,1,2,...11월
		int day   = calendar.get(Calendar.DAY_OF_MONTH); // 날짜
		int week = calendar.get(Calendar.DAY_OF_WEEK);//일:1, 월:2, 화:3, 수:4, ... 토:7
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY); //24시간단위
		int ampm = calendar.get(Calendar.AM_PM); // 0 or 1
		int hour = calendar.get(Calendar.HOUR); //12시간단위
		int minute = calendar.get(Calendar.MINUTE); // 분
		int second = calendar.get(Calendar.SECOND); // 초
		int milliSec = calendar.get(Calendar.MILLISECOND); // 밀리세컨
		System.out.printf("%d년 %d월 %d일 ", year, month, day);
		switch(week) {
		case 1: System.out.print("일요일 ");break;
		case 2: System.out.print("월요일 ");break;
		case 3: System.out.print("화요일 ");break;
		case 4: System.out.print("수요일 ");break;
		case 5: System.out.print("목요일 ");break;
		case 6: System.out.print("금요일 ");break;
		case 7: System.out.print("토요일 ");break;
		}
		System.out.print((ampm==0)? "오전 ":"오후 ");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, milliSec);
		System.out.printf("24시단위 : %d시 %d분 %d초 %d\n", hour24, minute, second, milliSec);
	}
}










