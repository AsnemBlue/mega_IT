package com.tj.ex1_string;
import java.util.Scanner;
public class Ex07_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-11"),
				new Friend("김길동", "010-9999-7777", "12-01"),
				new Friend("신길동", "02-333-7777", "12-10")};
		Scanner sc = new Scanner(System.in);
		boolean searchOk = false;
		String searchTel;
		System.out.print("검색할 친구의 전화번호 뒷자리는 ?");
		searchTel = sc.next(); // 7777
		for(Friend friend : friends) {
			String tel = friend.getTel();
			String postTel = tel.substring(tel.lastIndexOf('-')+1);
			if(postTel.equals(searchTel)) {
				System.out.println(friend.infoString());
				searchOk = true;
			}//if
		}//for
		if(!searchOk) {
			System.out.println("입력하신 전화번호 뒷자리를 갖는 친구는 없습니다");
		}
	}
}








