package com.tj.ex1_list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Ex04_link_vs_array {
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		LinkedList<String> linkedlist = new LinkedList<String>();
		System.out.println("arraylist 순차적 추가 시간 : "+addSequenceTime(arraylist));
		System.out.println("linkedlist 순차적 추가시간 : "+addSequenceTime(linkedlist));
		System.out.println("arraylist 랜덤 추가 시간 : "+addRandomTime(arraylist));
		System.out.println("linkedlist 랜덤 추가 시간 : "+addRandomTime(linkedlist));
		System.out.println("arraylist 랜덤 삭제 시간 : "+removeRandomTime(arraylist));
		System.out.println("linkedlist 랜덤 삭제 시간 : "+removeRandomTime(linkedlist));
		System.out.println("arraylist 순차적 삭제 시간 : "+removeSequenceTime(arraylist));
		System.out.println("linkedlist 순차적 삭제 시간 : "+removeSequenceTime(linkedlist));
	}
	private static long removeSequenceTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=list.size()-1 ; i>1000 ; i--) {
			list.remove(i); // 마지막 index를 차례로 삭제
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long removeRandomTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<1000 ; i++) {
			list.remove(10); 
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	private static long addRandomTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<1000 ; i++) {
			list.add(10, "랜덤추 추가");
		}
		long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long addSequenceTime(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0 ; i<5000000 ; i++) {
			list.add("순차적으로 추가");
		}
		long end = System.currentTimeMillis();
		return end-start;		
	}
}
