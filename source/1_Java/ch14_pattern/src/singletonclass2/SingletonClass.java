package singletonclass2;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass();
	public static SingletonClass getInstance() {
//		if(INSTANCE==null) {
//			INSTANCE = new SingletonClass();
//		}
		return INSTANCE;
	}
	private SingletonClass() {}
	public void setI(int i) {
		this.i = i;
	}
	public int getI() {
		return i;
	}
}
