package com.tj.ex4_bufferedReaderBufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
public class Ex01_bufferedReader {
	public static void main(String[] args) {
		Reader         reader = null;
		BufferedReader br     = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1.기본스트림열기
			br     = new BufferedReader(reader);           //   보조스트림은 기본스트림을 통해
			while(true) {
				String linedata = br.readLine();// 2.한줄씩 읽는다
				if(linedata==null) break; // 파일이 끝일 경우
				System.out.println(linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {                            // 3. 닫는다
				if(br    !=null) br.close();
				if(reader!=null) reader.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
