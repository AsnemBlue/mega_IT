package strategy1.step5.modularization;
import strategy1.step4.inter.FlyYes;
import strategy1.step4.inter.KnifeLazer;
import strategy1.step4.inter.MissileYes;
public class SuperRobot extends Robot{
	public SuperRobot() {
		setFly(new FlyYes());         // fly =  new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer());   // knife  = new KnifeLazer();
	}
}