package com.tj.ex12_book.cd;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;     // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대출중(1)or대출가능(0)
	public CDLib() { }
	// CDLib b = new CDLib("001-01","javacd","450-01ㄱ");
	public CDLib(String cdNo, String cdTitle, String bookNo) {
		super(cdNo, cdTitle, bookNo);
		state = STATE_NORMAL;
	}
	@Override
	public void checkOut(String borrower, String checkOutDate) { //b.checkOut("홍길동","12-06");
		if(state==STATE_BORROWED) { // 대출중상태라 메세지 뿌리고 return
			System.out.println(getCdNo()+" CD는 대출중입니다");
			return;
		}
		// 대출가능상태이므로 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출중 상태
		System.out.println(getCdTitle()+" 대출처리되었습니다.");
		System.out.println("대출인 : "+borrower);
		System.out.println("대출일 : "+checkOutDate);
	}
	@Override
	public void checkIn() {// b.checkIn()
		if(state==STATE_NORMAL) {
			System.out.println("이 CD는 대출가능상태이라 나오는데 이상하다. 예외다");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle()+" CD가 반납되었습니다.");
	}
	// b.printState() => 001-01 "java" 450-01ㄱ에 딸린 CD 대출중 (12-06)
	//                   001-01 "java" 450-01ㄱ에 딸린 CD 대출가능
	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" "+getBookNo()+"에 딸린 CD 대출가능");
		}else if(state==STATE_BORROWED) {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" "+getBookNo()+"에 딸린 CD 대출중("+checkOutDate+")");
		}else {
			System.out.println(getCdNo()+" \""+getCdTitle()+"\" 이상하다. 예외상황");
		}
	}
	public byte getState() {
		return state;
	}
}
