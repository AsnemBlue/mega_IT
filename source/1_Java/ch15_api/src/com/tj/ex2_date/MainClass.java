package com.tj.ex2_date;

public class MainClass {
	public static void main(String[] args) {
		Sawon1 s1 = new Sawon1("c100-01", "È«±æµ¿", "Àü»ê½Ç");
		Sawon1 s2 = new Sawon1("d100-01", "È«µðÀÚ", Sawon1.DESIGN);
		Sawon1 s3 = new Sawon1("h100-01", "È«ÀÎ»ç", Sawon1.HUMANRESOURCES, 2019, 2, 2);
		System.out.println(s1.infoString());
		System.out.println(s2.infoString());
		System.out.println(s3.infoString());
		Sawon2 s4 = new Sawon2("c100-02", "±è±æµ¿", PartType.COMPUTER);
		System.out.println(s4.infoString());
	}
}
