package strategy1.step5.modularization;

import strategy1.step4.inter.FlyHigh;

public class MainClass {
	public static void main(String[] args) {
		Robot[] robot = {new SuperRobot(), 
				new StandardRobot(), 
				new LowRobot()};
		System.out.println("요구사항 변경전");
		for(Robot r : robot) {
			System.out.println("=======================================");
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}
		System.out.println("요구사항 변경 후");
		robot[0].setFly(new FlyHigh());
		for(Robot r : robot) {
			System.out.println("=======================================");
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}
	}
}












