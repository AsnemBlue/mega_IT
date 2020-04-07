package com.tj.studentmng;
import java.util.Scanner;
public class StudentMngMain {
	public static void main(String[] args) {
		Student[] students = {new Student(201901,"홍길동",20,"기계"),
							  new Student(201902,"김길동",20,"경영"),
							  new Student(201903,"신길동",21,"컴공"),
							  new Student(201904,"마길동",21,"토목"),
							  new Student(201905,"박길동",20,"물리")
		};
		Scanner scanner = new Scanner(System.in);
		int no;  // 검색할 학번
		int idx; // 검색한 학번이 가르키는 index
		int fn;  // 기능번호 1:학번수정, 2:이름수정, 3:나이수정, 4:전공수정
		String data; // 바꿀 데이터가 입력될 변수
		for(Student s : students) {
			s.setAge(s.getAge()+9);
		}
		for(Student s : students) {
			System.out.println(s.infoString());
			//s.print();
		}
		while(true) {
			System.out.print("바꿀 학생의 학번은(단 종료를 원하면 0)?");
			no = scanner.nextInt();
			if(no==0) break;
			// 바꾸고 싶은 학생의 학번 받고
			// student[0] ~ student[4] no랑 같은 학번이 있는지 검색
			for(idx=0 ; idx<students.length ; idx++) {
				if(students[idx].getNo()==no) {
					break; // 찾았다. idx번째 있는 students[idx]를 수정할 예정
				}
			}
			if(idx == students.length) {
				//못찾은 경우
				System.out.println("유효하지 않은 학번을 입력하셨습니다.");
				continue;
			}
			// 기능번호 받고 1. 1~4 fn을 입력할 경우 2.유효하지 않는 fn일 경우
			System.out.print("1:학번수정, 2:이름수정, 3:나이수정, 4:전공수정. 원하는 기능번호는?");
			fn = scanner.nextInt();
			if(fn>4 || fn<1) {
				System.out.println("유효하지 않는 기능번호입니다.");
				continue;
			}
			// 바꿀 데이터 받고
			System.out.print("바꿀 데이터는 ?");
			data = scanner.next(); // String 입력(white space전까지의 String)
			// 수정전 데이터 출력 - 수정 - 수정후 데이터 출력
			System.out.println("수정 전 : "+students[idx].infoString());
			students[idx].modify(fn, data); // 수정
			System.out.println("수정 후 : "+students[idx].infoString());
		}
		System.out.println("안녕히 가세요. 최종 데이터는 다음과 같아요");
		for(Student s : students) {
			System.out.println(s.infoString());
		}
	}
}















