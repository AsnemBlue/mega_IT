package strategy3.modularization;

import strategy3.inter.GetSalary;
import strategy3.inter.JobLec;

public class Staff extends Person{
	private String part;
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobLec());     // 부품 조립
		setGet(new GetSalary());  // 부품 조립
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(반)"+part);
	}
}
