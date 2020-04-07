package strategy1.step5.modularization;

import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMissile;

public class Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife   knife;
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다");
	}
	public void shape() {
		System.out.println(getClass().getName()+"입니다. 외형은 팔 다리 몸통 머리가 있습니다.");
	}
	public void actionFly() {fly.fly();}
	public void actionMissile() {missile.missile();}
	public void actionKnife() {knife.knife();}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}
