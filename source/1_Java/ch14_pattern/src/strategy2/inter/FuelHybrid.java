package strategy2.inter;

public class FuelHybrid implements IFuel{

	@Override
	public void fuel() {
		System.out.println("전기와 휘발유로 움직입니다");
	}

}
