package com.tj.question;
import java.util.Scanner;
// 입력한 두수를 비교연산자들(같다, 크다, 작다, 크거나작다, 작거나같다, 다르다)을 이용하여,
//    비교한 결과가  true면 O, false면 X를 출력하시요
public class Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수 : ");
		int num1 = scanner.nextInt();
		System.out.print("두번째 수 : ");
		int num2 = scanner.nextInt();
		boolean result = num1 == num2;
		System.out.println("num1 == num2의 결과는 "+ ( (result==true)? "O":"X") );
		result = num1 != num2;
		System.out.println("num1 != num2의 결과는 "+ ( (result==true)? "O":"X") );
		result = num1 > num2;
		System.out.println("num1 > num2의 결과는 "+ ( (result==true)? "O":"X") );
		result = num1 < num2;
		System.out.println("num1 < num2의 결과는 "+ ( (result==true)? "O":"X") );
		scanner.close();
	}
}





