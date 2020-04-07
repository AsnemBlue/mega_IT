package com.tj.ex1_inputStreamOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Ex03_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("d:/mega_IT/outTest.txt"); // 1.스트림연다
			byte[] bs = {'H','e','l','l','o',',','J','a','v','a','\r','\n','H'};
			for(int i=0 ; i<bs.length ; i++) { // 2.데이터쓴다
				os.write(bs[i]);
				System.out.print((char)bs[i]);
			}
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
