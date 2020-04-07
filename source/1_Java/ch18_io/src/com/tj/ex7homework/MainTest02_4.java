package com.tj.ex7homework;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MainTest02_4 {
	public static void main(String[] args) {
		// 1. N(n)을 입력할 때까지 회원정보를 ArrayList에 받는다(오늘 생일이면 축하메세지출력)
		Scanner scanner = new Scanner(System.in);
		String keepgoing, name, phone, birth, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			System.out.print("회원가입을 하실래요(Y/N) ? ");
			keepgoing = scanner.next();
			if(keepgoing.equalsIgnoreCase("n")) break;
			System.out.print("회원이름 ? ");
			name = scanner.next();
			System.out.print("전화번호 ? ");
			phone = scanner.next();
			System.out.print("생일(mm-dd) ? ");
			birth = scanner.next();
			System.out.print("주소 ? ");
			scanner.nextLine();
			address = scanner.nextLine();
			if(birth.equals(todayStr)) {
				System.out.println(name+"님 생일이시군요. 생일축하합니다");
			}
			customers.add(new Customer(name, phone, birth, address));
		}while(true);
		// 2. ArrayList 정보와 몇명 가입했는지 파일 출력과 콘솔 출력한다
		PrintWriter printwriter = null;
		try {
			printwriter = new PrintWriter("src/com/tj/ex7homework/customer.txt");
			for(Customer c:customers) {
				System.out.print(c);
				printwriter.print(c.toString());
			}
			System.out.println("        ....이하 "+customers.size()+"명 가입");
			printwriter.println("        ....이하 "+customers.size()+"명 가입");
		} catch (IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());
		}finally {
			try {
				printwriter.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}
	}
}
