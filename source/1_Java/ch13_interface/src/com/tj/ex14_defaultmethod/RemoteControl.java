package com.tj.ex14_defaultmethod;
public interface RemoteControl {
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	public default void mute(boolean mute) {//tv.mute(true)
		if(mute) {
			System.out.println("무음 처리");
		}else {
			System.out.println("무음 해제");
		}
	}
	public static void changeBattery() {
		System.out.println("건전지 교환합니다");
	}
}
