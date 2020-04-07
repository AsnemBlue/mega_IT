package strategy1.step4.inter;
public class MissileNo implements IMissile{
	@Override
	public void missile() {
		System.out.println("마사일을 쏠 수 없습니다");
	}
}
