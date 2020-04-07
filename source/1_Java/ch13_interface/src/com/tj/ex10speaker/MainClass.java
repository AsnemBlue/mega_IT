package com.tj.ex10speaker;
public class MainClass {
	public static void main(String[] args) {
		IVolume[] volumes = {new Speaker(3), new TV(6)};
		for(IVolume vol : volumes) {
			vol.volumeUp(10);
			vol.volumeUp(10);
			vol.volumeUp(11);
			vol.volumeDown(50);
		}
	}
}
