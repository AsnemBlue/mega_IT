package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Ex07_simpleDateFormat {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		String todayStr = sdf.format(cal.getTime());
		// cal.getTime()는 cal을 date형으로 바꾼 것
		System.out.println(todayStr);
		// yyyy 2019 yy 19
		// M 9 MM 09
		// d 9 dd 09 이번달의 몇번째 날(1~31)
		// D 올해에 몇번째 날(1~365)
		// E 요일
		// a 오전/오후
		// H 24시간 3 HH 03
		// h 12시간 3 hh 03
		// m 9 mm 09 분
		// s 초
		// S 밀리세컨
		// W 이번 월의 몇번째 주인지
		// w 이번 년도의 몇번째 주인지
	}
}
