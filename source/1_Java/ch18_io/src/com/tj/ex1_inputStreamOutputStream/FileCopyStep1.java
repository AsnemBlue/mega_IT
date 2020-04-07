package com.tj.ex1_inputStreamOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// 입력스트림연다,출력스트림연다 - > 읽은데이터그대로write한다 -> 입력스트림과출력스트림을닫는다
public class FileCopyStep1 {
	public static void main(String[] args) {
		InputStream  is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("txtFile/bts.jpg");
			os = new FileOutputStream("txtFile/bts_copy.jpg");
			int cnt = 0;
			while(true) {
				cnt++;
				int i = is.read(); // 읽고
				if(i==-1) break;
				os.write(i);       // 쓰고
			}
			System.out.println("파일 카피 끝. while문 몇번 돌았는지 : "+cnt);
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 "+e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기 예외 "+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
