package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
// 1. 스트림연다  2.읽는다 3.닫는다
public class Ex02_inputStream3byte {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("d:/mega_IT/inTest.txt"); // 1.스트림 연다
			byte[] bs = new byte[10];
			while(true) {
				int readByteCount = is.read(bs); // 2. 3byte씩 읽는다. 
				if(readByteCount==-1) break;
				for(int i=0 ; i<readByteCount ; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException ignore) {System.out.println(ignore.getMessage());}
		}
	}
}
