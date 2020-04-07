package strategy3.inter;
public class GetStudentPay implements IGet {
	@Override
	public void getMoney() {
		System.out.println("교육급여를 받습니다");
	}
}
