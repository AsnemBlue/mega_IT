package strategy3.modularization;

import strategy3.inter.GetStudentPay;
import strategy3.inter.JobStudy;

public class Student extends Person{
	private String ban;
	public Student() {}
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());      // 부품 조립
		setGet(new GetStudentPay()); // 부품 조립
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(반)"+ban);
	}
}
