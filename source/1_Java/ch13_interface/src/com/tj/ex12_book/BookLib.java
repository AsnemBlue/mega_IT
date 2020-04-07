package com.tj.ex12_book;

public class BookLib extends BookInfo implements ILendable {
	private String borrower;     // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대출중(1)or대출가능(0)
	public BookLib() { }
	// BookLib b = new BookLib("450-01ㄱ","java","신용권");
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) { //b.checkOut("홍길동","12-06");
		if(state==STATE_BORROWED) { // 대출중상태라 메세지 뿌리고 return
			System.out.println(getBookTitle()+" 도서는 대출중입니다");
			return;
		}
		// 대출가능상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출중 상태
		System.out.println(getBookTitle()+" 대출처리되었습니다.");
		System.out.println("대출인 : "+borrower);
		System.out.println("대출일 : "+checkOutDate);
	}
	@Override
	public void checkIn() {// b.checkIn()
		if(state==STATE_NORMAL) {
			System.out.println("이 책은 대출가능상태이라 나오는데 이상하다. 예외다");
			return;
		}
		
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle()+" 도서가 반납되었습니다.");
	}
	// b.printState() => 840-0ㄱ "java" 신용권저 대출중 (12-06)
	//                   840-0ㄱ "java" 신용권저 대출가능
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" "+getWriter()+"저 대출가능");
		}else if(state==STATE_BORROWED) {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" "+getWriter()+"저 대출중("+checkOutDate+")");
		}else {
			System.out.println(getBookNo()+" \""+getBookTitle()+"\" 이상하다. 예외상황");
		}
	}
	public byte getState() {
		return state;
	}
}
