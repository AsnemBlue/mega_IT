package com.tj.ex4_bufferedReaderBufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
public class Ex03_keyboard {
	public static void main(String[] args) {
		Writer writer = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("저장할 파일이름은 ? ");
		try {
			String filename = keyboard.readLine();
			writer = new FileWriter(filename);// 입력한 파일이름으로 스트림 연다
			while(true) {
				System.out.print("파일 내용은?(더 이상 내용이 없을 때 x입력)");
				String content = keyboard.readLine();
				if(content.equalsIgnoreCase("x")) break;
				writer.write(content+"\r\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(writer  !=null) writer.close();
				if(keyboard!=null) keyboard.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
