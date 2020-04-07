package com.tj.ex5_lib;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BookMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("890-01", "this is java", "신용권"),
				new BookLib("890-02", "dbms", "박용권"),
				new BookLib("890-03", "html", "김용권"),
				new BookLib("890-04", "css", "이용권"),
				new BookLib("890-05", "jsp", "윤용권")	};
		Scanner sc = new Scanner(System.in);
		int fn; // 기능번호
		int idx; // 대출이나 반납을 처리할 책의 index
		String bTitle, borrower;
		do {
			System.out.print("0:전체 대출여부 상태 열람 1.대출, 2.반납, 그외:종료");
			try {
				fn = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("0,1,2 그 외 문자를 입력하시면 종료되요");
				break;
			}
			switch(fn) {
			case 0:
				for(BookLib book : books) {
					System.out.println(book);
				}
				break;
			case 1: 
				//대출처리 1.책이름입력 2.책검색 3.책상태확인 4.대출자입력 5.대출처리 
				System.out.print("대출하고자 하는 책이름은?");            // (1)단계. 책이름입력
				sc.nextLine();
				bTitle = sc.nextLine(); // 책이름에 space까지 받음.
				for(idx=0 ; idx<books.length ; idx++) {                  // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;//찾았다. 이거 대출하면 되겠다
					}
				}
				// idx<books.length경우는 찾았다. idx==books.length경우는 못찾았다
				if(idx==books.length) {
					System.out.println("현재 보유하지 않은 도서입니다.");
				}else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {// (3) 단계. 책상태확인
						System.out.println("현재 대출중인 도서입니다.");
					}else {
						System.out.print("대출자는?");// (4)단계. 대출자입력
						borrower = sc.next();
						try {
							books[idx].checkOut(borrower);// (5)대출처리
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
				break;
			case 2:
				//반납처리 1.책이름 2.책검색 3.반납처리
				System.out.print("반납할 책이름은?"); //(1)단계. 책이름
				sc.nextLine();
				bTitle = sc.nextLine(); // 책이름에 space까지 받음.
				for(idx=0 ; idx<books.length ; idx++) { // (2)단계. 책검색
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //찾아서 나가
					}
				}
				if(idx==books.length) {
					System.out.println("이도서는 본도서관 보유책이 아닙니다.");
				}else {
					try {
						books[idx].checkIn(); // (3)단계. 반납처리
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			default:
				System.out.println("0,1,2 그 외 문자를 입력하시면 종료되요");
				//System.exit(0);
			}
		}while(fn==0 || fn==1 || fn==2);
		sc.close();
	}
}















