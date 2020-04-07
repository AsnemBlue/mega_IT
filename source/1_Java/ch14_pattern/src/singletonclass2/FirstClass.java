package singletonclass2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("½Ì±ÛÅæ°´Ã¼ÀÇ i°ª : "+singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("½Ì±ÛÅæ °´Ã¼ÀÇ ¼öÁ¤ÈÄ i°ª : "+singletonObject.getI());
		
	}
}
