package strategy1.step5.modularization;
import strategy1.step4.inter.FlyNo;
import strategy1.step4.inter.KnifeWood;
import strategy1.step4.inter.MissileYes;
public class StandardRobot extends Robot{
	public StandardRobot() {
		setFly(new FlyNo());         //fly = new FlyNo();
		setMissile(new MissileYes());//missile = new MissileYes();
		setKnife(new KnifeWood());   //knife = new KnifeWood();
	}
}
