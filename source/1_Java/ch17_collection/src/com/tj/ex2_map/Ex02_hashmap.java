package com.tj.ex2_map;
import java.util.HashMap;
import java.util.Iterator;
public class Ex02_hashmap {
	public static void main(String[] args) {
		HashMap<String, String> hasp = new HashMap<String, String>();
		hasp.put("È«±æµ¿", "010-9999-9999");
		hasp.put("±è±æµ¿", "010-8888-8888");
		hasp.put("½Å±æµ¿", "010-7777-9999");
		System.out.println(hasp);
		Iterator<String> iterator = hasp.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key+ ":"+hasp.get(key));
		}
	}
}
