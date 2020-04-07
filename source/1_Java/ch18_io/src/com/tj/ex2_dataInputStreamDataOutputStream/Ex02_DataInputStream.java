package com.tj.ex2_dataInputStreamDataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class Ex02_DataInputStream {
	public static void main(String[] args) {
		InputStream     fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis); //보조스트림은 기본스트림을 통해 연다
			String name = dis.readUTF(); // 읽는다(쓴 순서대로)
			int   grade = dis.readInt();
			double score = dis.readDouble();
			System.out.println("파일로 부터 입력받은 값은 "+name+"\t"+grade+"\t"+score);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
