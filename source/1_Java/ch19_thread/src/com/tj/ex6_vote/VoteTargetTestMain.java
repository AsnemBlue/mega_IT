package com.tj.ex6_vote;

public class VoteTargetTestMain {
	public static void main(String[] args) {
		Runnable target1 = new VoteTarget();
		Runnable target2 = new VoteTarget();
		Runnable target3 = new VoteTarget();
		Thread location1 = new Thread(target1, "location1");
		Thread location2 = new Thread(target2, "location2");
		Thread location3 = new Thread(target3, "location3");
		location1.start();
		location2.start();
		location3.start();
	}
}
