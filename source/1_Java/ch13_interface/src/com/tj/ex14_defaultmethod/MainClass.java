package com.tj.ex14_defaultmethod;

public class MainClass {
	public static void main(String[] args) {
		RemoteControl audio = new Audio();
		audio.turnOn();
		audio.setVolume(15);
		audio.turnOff();
		RemoteControl tv = new TV();
		tv.turnOn();
		tv.setVolume(-5);
		tv.turnOff();
		tv.mute(true);
	}
}
