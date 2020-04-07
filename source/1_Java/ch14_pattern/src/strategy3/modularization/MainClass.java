package strategy3.modularization;

public class MainClass {
	public static void main(String[] args) {
		Student st1 = new Student("30301", "강동원", "영화반");
		Student st2 = new Student("30302", "강예원", "Java반");
		Gangsa gs1 = new Gangsa("J01", "홍길동", "java");
		Gangsa gs2 = new Gangsa("J02", "김철수", "db");
		Staff s = new Staff("A01", "유국동", "취업지원");
		Person[] person = {st1, st2, gs1, gs2, s};
		System.out.println("* * * 업무시간이니 다 일합시다 * * *");
		for(Person p : person)
			p.job();
		System.out.println("* * * 월말엔 다 지급할 것 지급 * * *");
		for(Person p : person)
			p.get();
		System.out.println("* * * 궁금하면 프린트 * * *");
		for(Person p : person)
			p.print();
	}
}
