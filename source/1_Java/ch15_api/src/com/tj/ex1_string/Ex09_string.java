package com.tj.ex1_string;
// String은 메모리를 과소비(데이터가 변할 때) - 이 단점을 보완 : StringBuffer, StringBuilder
public class Ex09_string {
	public static void main(String[] args) {
		String str1 = "Java"; // 100번지
		String str2 = str1;   // 100번지
		str1 = "Python";      // 200번지
		if(str1 == str2) {
			System.out.println("str1과 str2는 같은 주소네");
		}else {
			System.out.println("str1과 str2는 다른 주소네");
		}
		str1 = "Python1";   // 300번지
	}
}
