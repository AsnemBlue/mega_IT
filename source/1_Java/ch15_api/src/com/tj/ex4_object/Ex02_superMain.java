package com.tj.ex4_object;

public class Ex02_superMain {
	public static void main(String[] args) {
		Goods[] goods = {new Goods("a01", "»õ¿ì±ø", 1500, 10),
				new Goods("a02", "¾çÆÄ¸µ", 1300, 10)	};
		Customer[] customers = {new Customer("010-9999-9999", "È«±æµ¿", "01-11"),
				new Customer("010-8888-8888", "±è±è±è", "12-11")	};
		for(Goods good : goods) {
			System.out.println(good);
		}
		for(Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
