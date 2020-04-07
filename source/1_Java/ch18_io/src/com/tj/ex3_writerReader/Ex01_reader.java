package com.tj.ex3_writerReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class Ex01_reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");//1.스트림연다
			while(true) {
				int i = reader.read(); // 2.읽는다(2byte씩 읽는다)
				if(i==-1) break;
				System.out.println((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader!=null) reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
