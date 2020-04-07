package com.tj.ex8_decimalformat;
import java.text.DecimalFormat;
public class Ex01 {
	public static void main(String[] args) {
		double number = 1234567.8889;
		String[] patterns = {"00000000.00000", "########.#####", 
				"#,###.##", "0,000.00", "#.##%", "#.###E0"};
		for(String p : patterns) {
			DecimalFormat df = new DecimalFormat(p);
			System.out.println(df.format(number));
		}
	}
}
