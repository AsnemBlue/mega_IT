package singletonclass1;

public class SingletonMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance();
		obj1.setI(99);
		SingletonClass obj2 = SingletonClass.getInstance();
		System.out.println(obj2.getI());
		System.out.println(obj1.getI());
	}
}