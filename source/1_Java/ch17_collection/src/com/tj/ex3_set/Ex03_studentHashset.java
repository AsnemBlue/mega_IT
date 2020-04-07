package com.tj.ex3_set;
import java.util.HashSet;
import java.util.Iterator;
public class Ex03_studentHashset {
	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();
		Student h2 = new Student("È«±æµ¿", 1);
		Student h1 = new Student("È«±æµ¿", 1);
		hashset.add(h1);
		hashset.add(h2);
		hashset.add(new Student("±è±æµ¿", 1));
		hashset.add(new Student("¸¶±æµ¿", 1));
		hashset.remove(h2);
		System.out.println(hashset);
		Iterator<Student> iterator = hashset.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
