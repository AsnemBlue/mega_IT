package singletonclass1;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE;
	// 객체를 생성이 안되어 있으면 생성하고
	// 객체생성된 것이 있으면 그 객체의 주소를 return
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	private SingletonClass() {}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
