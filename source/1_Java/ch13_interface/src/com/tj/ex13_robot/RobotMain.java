package com.tj.ex13_robot;

public class RobotMain {
	public static void main(String[] args) {
		Robot[] robots = {new SingRobot(), new DrawRobot(), new DanceRobot(), new DanceRobot()};
		RobotOrder order = new RobotOrder();
		for(Robot robot : robots) {
			order.action(robot);
		}
	}
}
