package com.tj.ex2_date;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Ex05 {
	public static void main(String[] args) {
		// 현재
		Calendar calNow = Calendar.getInstance();
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dateNow = new Date();
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", calNow);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", gcNow);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateNow);
		// 특정한 시점 (1990.12.11)
		GregorianCalendar gcThat   = new GregorianCalendar(1990, 11, 11);
		Date              dateThat1 = new Date(90, 11, 11);
		Date              dateThat2 = new Date(gcThat.getTimeInMillis());
		Date dateThat3 = new Date(new GregorianCalendar(1990,11,11).getTimeInMillis()); ///
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", gcThat);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateThat1);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateThat2);
		System.out.printf("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초\n", dateThat3);
	}
}
