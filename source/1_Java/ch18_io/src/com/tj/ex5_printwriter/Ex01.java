package com.tj.ex5_printwriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
public class Ex01 {	
	public static void main(String[] args) {
		OutputStream os = null;          // 1byte기본스트림
		Writer       writer = null;      // 2byte기본스트림
		PrintWriter  printWriter = null; // 보조스트림
		try {
			//os = new FileOutputStream("txtFile/outTest.txt");//기본스트림
			//printWriter = new PrintWriter(os);               // 보조스트림
//			writer = new FileWriter("txtFile/outTest.txt");  //기본스트림
//			printWriter = new PrintWriter(writer);               // 보조스트림
			printWriter = new PrintWriter("txtFile/outTest.txt");
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\r\n반갑습니다");
			System.out.printf("%5s %3d %3d %5.1f\n", "홍길동",100, 100, 100.0);
			printWriter.printf("%5s %3d %3d %5.1f\n", "홍길동",100, 100, 100.0);
			System.out.printf("%5s %3d %3d %5.1f\n", "마길동",99, 100, 99.5);
			printWriter.printf("%5s %3d %3d %5.1f\n", "마길동",99, 100, 99.5);
			System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초", new Date());
			printWriter.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초", new Date());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				printWriter.close();
				//if(os!=null) os.close();
				//if(writer!=null) writer.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}





