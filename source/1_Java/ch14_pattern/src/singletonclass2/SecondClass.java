package singletonclass2;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("Second 클래스 생성자 실행중");
		System.out.println("싱글톤 객체의 i값 : "+singletonObject.getI());
		System.out.println("Second 클래스 생성자 끝");
	}
}
