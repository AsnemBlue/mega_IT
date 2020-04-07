package com.tj.ex2_date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
public class Sawon2 {
	private String no; // d102-01
	private String name;
	private PartType part;//COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES
	private Date enterDate;
	// Sawon1 kim = new Sawon1("d102-01","홍길동",PartType.COMPUTER);
	public Sawon2(String no, String name, PartType part) {
		this.no = no; this.name = name; this.part = part;
		enterDate = new Date();
	}
	// Sawon1 yi = new Sawon1("d102-02", "홍","DESIGN",1990,12,11);
	public Sawon2(String no, String name, PartType part, int year, int month, int day) {
		this.no = no; this.name = name; this.part = part;
		//enterDate = new Date(year-1900, month-1, day);
		enterDate = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
	}
	public String infoString() {
		// [사번]d102-02 [이름]홍 [부서]DESIGN [입사일]1990년2월2일
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년M월d일");
		String enterDateStr = sdf.format(enterDate);
		return "[사번]"+no+" [이름]"+name+" [부서]"+part+" [입사일]"+enterDateStr;
	}
}










