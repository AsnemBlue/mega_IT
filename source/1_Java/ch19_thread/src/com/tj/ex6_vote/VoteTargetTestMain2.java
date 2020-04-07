package com.tj.ex6_vote;

public class VoteTargetTestMain2 {
	public static void main(String[] args) {
		Thread location1 = new VoteTarget2("location1");
		Thread location2 = new VoteTarget2("location2");
		Thread location3 = new VoteTarget2();
		location3.setName("location3");
		location1.start();
		location2.start();
		location3.start();
	}
}
