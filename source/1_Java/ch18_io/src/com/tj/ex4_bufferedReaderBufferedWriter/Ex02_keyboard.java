package com.tj.ex4_bufferedReaderBufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
public class Ex02_keyboard {
	public static void main(String[] args) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); // 키보드
		Reader     reader = null; // 기본스트림
		BufferedReader br = null; // 보조스트림
		System.out.print("읽어올 파일 이름은 ?");
		try {
			String filename = keyboard.readLine(); // 파일 이름입력
			File file = new File(filename);  // 입력된 파일이름으로 파일객체
			if(file.exists()) {//존재하는 파일
				reader = new FileReader(file); // 기본스트림 연다
				br     = new BufferedReader(reader); // 보조스트림은 기본스트림을 통해 연다
				while(true) {
					String linedata = br.readLine();
					if(linedata==null) break;
					System.out.println(linedata);
				}
			}else {
				System.out.println("입력하신 파일은 존재하지 않아 읽을 수 없어");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(br      !=null) br.close();
				if(reader  !=null) reader.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}







