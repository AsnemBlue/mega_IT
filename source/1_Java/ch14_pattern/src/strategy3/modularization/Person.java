package strategy3.modularization;
import strategy3.inter.IGet;
import strategy3.inter.IJob;
public class Person {
	private String id;
	private String name;
	private IJob job;
	private IGet get;
	public Person() {}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void job() {
		job.jobAny();
	}
	public void get() {
		get.getMoney();
	}
	public void print() {
		System.out.print("(ID)"+id+"\t(¿Ã∏ß)"+name);
	}
	public void setJob(IJob job) {this.job = job;}
	public void setGet(IGet get) {this.get = get;}
}
