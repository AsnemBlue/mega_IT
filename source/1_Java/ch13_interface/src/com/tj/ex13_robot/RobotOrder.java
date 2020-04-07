package com.tj.ex13_robot;
// RobotOrder order = new RobotOrder();
// DanceRobot r = new DanceRobot();
// order.action(r);
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof SingRobot) {
			SingRobot r = (SingRobot)robot;
			r.sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot r = (DrawRobot)robot;
			r.draw();
		}else if(robot instanceof DanceRobot) {
			DanceRobot r = (DanceRobot)robot;
			r.dance();
		}else {
			System.out.println("확장된 로봇이면 구현이 필요합니다.");
		}
	}
}
