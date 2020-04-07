package com.tj.ex7homework;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class MainTest01_2 {
	public static void main(String[] args) {
		// 1. N(n)을 입력할 때까지 회원정보를 ArrayList에 받는다(오늘 생일이면 축하메세지출력)
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String keepgoing, name, phone, birth, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todayStr = sdf.format(today);
		do {
			try {
				System.out.print("회원가입을 하실래요(Y/N) ? ");
				keepgoing = keyboard.readLine();
				if(keepgoing.equalsIgnoreCase("n")) break;
				System.out.print("회원이름 ? ");
				name = keyboard.readLine();
				System.out.print("전화번호 ? ");
				phone = keyboard.readLine();
				System.out.print("생일(mm-dd) ? ");
				birth = keyboard.readLine();
				System.out.print("주소 ? ");
				address = keyboard.readLine();
				if(birth.equals(todayStr)) {
					System.out.println(name+"님 생일이시군요. 생일축하합니다");
				}
				customers.add(new Customer(name, phone, birth, address));
			}catch ( IOException e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		// 2. ArrayList 정보와 몇명 가입했는지 파일 출력과 콘솔 출력한다
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/tj/ex7homework/customer.txt");
			for(Customer c:customers) {
				System.out.print(c);
				writer.write(c.toString());
			}
			System.out.println("        ....이하 "+customers.size()+"명 가입");
			String msg = "        ....이하 "+customers.size()+"명 가입";
			writer.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());
		}finally {
			try {
				if(writer!=null) writer.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}
	}
}
