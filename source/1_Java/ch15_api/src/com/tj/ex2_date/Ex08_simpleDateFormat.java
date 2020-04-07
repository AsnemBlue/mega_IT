package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class Ex08_simpleDateFormat {
	public static void main(String[] args) {
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(gc.getTime());
		System.out.println(todayStr);
	}
}
