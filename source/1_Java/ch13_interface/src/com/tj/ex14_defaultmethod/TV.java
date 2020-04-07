package com.tj.ex14_defaultmethod;

public class TV implements RemoteControl{
	private int volume;
	@Override
	public void turnOn() {
		System.out.println("TV¸¦ ÄÕ´Ï´Ù");
	}
	@Override
	public void turnOff() {
		System.out.println("TV¸¦ ²ü´Ï´Ù");
	}
	@Override
	public void setVolume(int volume) {
		if(volume<MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		}else if(volume>MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		}else {
			this.volume =  volume;
		}
		System.out.println("ÇöÀç TV º¼·ýÀº "+this.volume);
	}

}
