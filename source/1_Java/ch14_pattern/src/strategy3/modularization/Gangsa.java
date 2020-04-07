package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobLec;

public class Gangsa extends Person {
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());     // 何前 炼赋
		setGet(new GetSalary());  // 何前 炼赋
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(苞格)"+subject);
	}
}
