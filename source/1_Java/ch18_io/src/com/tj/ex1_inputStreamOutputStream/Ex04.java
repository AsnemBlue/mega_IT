package com.tj.ex1_inputStreamOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Ex04 {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // 1.스트림연다 true:append
			String str = "안녕하세요\r\n반갑습니다";
			byte[] bs = str.getBytes(); 
			os.write(bs);
		}catch(FileNotFoundException e) {
			System.out.println("파일못찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 오류"+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
