package strategy1.step4.modularization;
import strategy1.step4.inter.FlyNo;
import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMissile;
import strategy1.step4.inter.KnifeWood;
import strategy1.step4.inter.MissileYes;
public class StandardRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife   knife;
	public StandardRobot() {
		setFly(new FlyNo());         //fly = new FlyNo();
		setMissile(new MissileYes());//missile = new MissileYes();
		setKnife(new KnifeWood());   //knife = new KnifeWood();
	}
	@Override
	public void actionFly() {fly.fly();}
	@Override
	public void actionMissile() {missile.missile();}
	@Override
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
