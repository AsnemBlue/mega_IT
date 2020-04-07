package com.tj.ex1_list;
import java.util.ArrayList;
public class Ex01_arrayList {
	public static void main(String[] args) {
		String[] array = new String[3]; // 스트링 배열
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		array[1] = "1111";
		for(int idx=0 ; idx<array.length ; idx++) {
			System.out.println(idx+"번째 "+array[idx]);
		}
		
		ArrayList<String> arrayList = new ArrayList<String>(); // 스트링 arrayList
		arrayList.add("str0"); // 0번 인덱스
		arrayList.add("str1"); // 1번 인덱스
		arrayList.add("str2"); // 2번 인덱스
		arrayList.add(1, "str111111111"); 
		arrayList.set(1, "11111111");
		for(int idx=0 ; idx<arrayList.size() ; idx++) {
			System.out.println(idx+"번째 "+arrayList.get(idx));
		}
		arrayList.remove(1); // 1번 인덱스 arrayList를 지움
		System.out.println(arrayList.toString());
		arrayList.clear(); // arrayList의 모든 데이터를 지움 (size()를 0ㅇ로)
		if(arrayList.isEmpty()) {
			System.out.println("arrayList.clear()됨");
		}
		arrayList = null;
		arrayList.add("str");
	}
}






