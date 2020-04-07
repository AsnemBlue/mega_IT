package com.tj.ex2_dataInputStreamDataOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class ProductArrayList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream     fis = null;
		DataInputStream dis = null;
		String name; int price; int ps;
		try {
			fis = new FileInputStream("txtFile/product.dat"); // 기본스트림 연다
			dis = new DataInputStream(fis);                   // 보조스트림 연다
			while(true) {
				name = dis.readUTF(); // 물건명
				price = dis.readInt();//가격
				ps = dis.readInt(); // ps
				// 1셋트 가져온 재고량을 products에 추가
				products.add(new Product(name, price, ps));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("product.dat 파일 내용을 arraylist에 담음 끝");
		} finally {
			try {
				if(dis!=null) dis.close();
				if(fis!=null) fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}// try - close
		}// try-catch-finally
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("이상 "+products.size()+"개 재고입력됨");
	}//main
}//class




