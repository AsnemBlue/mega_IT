package strategy1.step4.modularization;
import strategy1.step4.inter.FlyYes;
import strategy1.step4.inter.IFly;
import strategy1.step4.inter.IKnife;
import strategy1.step4.inter.IMissile;
import strategy1.step4.inter.KnifeLazer;
import strategy1.step4.inter.MissileYes;
public class SuperRobot extends Robot{
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	public SuperRobot() {
		setFly(new FlyYes());         // fly =  new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer());   // knife  = new KnifeLazer();
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
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
}