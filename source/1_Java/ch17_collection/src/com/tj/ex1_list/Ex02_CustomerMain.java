package com.tj.ex1_list;
import java.util.ArrayList;
import java.util.Scanner;
public class Ex02_CustomerMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		do {
			System.out.print("회원가입을 진행하시겠습니까(Y/N)?");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("y")) { 
				System.out.print("가입할 회원의 이름은 ?");
				name = scanner.next();
				System.out.print("가입할 회원의 폰번호는 ?");
				phone = scanner.next();
				scanner.nextLine(); // 버퍼에 남아있는 '\n'을 지우는 용도
				System.out.print("가입할 회원의 주소는 ?");
				address = scanner.nextLine();
				customers.add(new Customer(name, phone, address));
			}else if(answer.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);
		System.out.println(customers);
//		for(Customer customer :  customers) {
//			System.out.println(customer);
//		}
		for(int idx=0 ; idx<customers.size() ; idx++) {
			System.out.println(customers.get(idx));
		}
	}
}








