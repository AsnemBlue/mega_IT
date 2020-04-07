package strategy1.step1;

public class RobotMain {
	public static void main(String[] args) {
		SuperRobot    superR    = new SuperRobot();
		StandardRobot standardR = new StandardRobot();
		LowRobot      lowR      = new LowRobot();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		superR.shape();
		superR.actionWalk();
		superR.actionRun();
		superR.actionFly();
		superR.actionMissile();
		superR.actionKnife();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		standardR.shape();
		standardR.actionWalk();
		standardR.actionRun();
		standardR.actionFly();
		standardR.actionMissile();
		standardR.actionKnife();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		lowR.shape();
		lowR.actionWalk();
		lowR.actionRun();
		lowR.actionFly();
		lowR.actionMissile();
		lowR.actionKnife();
	}
}
