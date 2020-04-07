package com.tj.ex4_object;
public class Card {
	private char kind; // ♥ ◆ ♣ ♠
	private int num;  // A(1), 2~10, 11,12,13
	// Card c1 = new Card('♥',2);
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "선택하신 카드는 "+kind+"  "+num;
	}
	@Override
	public boolean equals(Object obj) {
		//c1.equals(c2) c1->this c2->obj
		if(obj!=null && obj instanceof Card) {
			boolean kindChk = this.kind == ((Card)obj).kind; 
			boolean numChk  = this.num == ((Card)obj).num;
			return kindChk && numChk;
		}else {
			return false;
		}
	}
}
















