package com.tj.ex1_list;
import java.util.LinkedList;
public class Ex03_linkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("str0"); // 1 index
		linkedlist.add("str1");
		linkedlist.add(0, "str00");
		linkedlist.set(0, "0000"); //0 index
		linkedlist.remove(2);
		for(int idx=0 ; idx<linkedlist.size() ; idx++) {
			System.out.println(linkedlist.get(idx));
		}
		System.out.println(linkedlist);
		linkedlist.clear();
		System.out.println(linkedlist.isEmpty()? "비워졌다.":"안 비워졌네");
	}
}
