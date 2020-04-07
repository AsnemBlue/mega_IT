package com.tj.ex1_string;
import java.util.Scanner;
// substring() lastIndexOf()
public class Ex06 {
	public static void main(String[] args) {
		String[] tels = {"010-1111-9999", "010-1111-8888", "02-325-9999", "02-3333-9999"};
		Scanner sc = new Scanner(System.in);
		String searchTel;
		int idx;
		boolean searchOk = false; // 검색한 결과가 있으면 true로 할 예정
		System.out.print("검색하고자 하는 회원의 전화번호 뒷자리는?");
		searchTel = sc.next(); // 9999
		for(idx=0 ; idx<tels.length ; idx++) {
			// 전화번호 뒷자리 빼내기
			String temp = tels[idx].substring( tels[idx].lastIndexOf('-')+1 );
			if(temp.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 "+tels[idx]);// 전화번호 찾았다.
				searchOk = true;
			}
		}
		if(!searchOk) { //searchTel이 배열전화에 없는 경우(못 찾고 끝까지 간 경우)
			System.out.println("검색하신 전화번호는 없습니다.");
		}
	}
}











