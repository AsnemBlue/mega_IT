package com.tj.ex8_decimalformat;
import java.text.DecimalFormat;
public class Ex02 {
	public static void main(String[] args) {
		double number = 1234567.8889;
		DecimalFormat df1 = new DecimalFormat("00000000.00000"); // 0
		System.out.println(df1.format(number));
		DecimalFormat df2 = new DecimalFormat("########.#####");
		System.out.println(df2.format(number));
		DecimalFormat df3 = new DecimalFormat("#,###.##");
		System.out.println(df3.format(number));
		DecimalFormat df4 = new DecimalFormat("0,000.00");
		System.out.println(df4.format(number));
		DecimalFormat df5 = new DecimalFormat("#.##%");
		System.out.println(df5.format(number));
		DecimalFormat df6 = new DecimalFormat("#.###E0");
		System.out.println(df6.format(number));
	}
}
