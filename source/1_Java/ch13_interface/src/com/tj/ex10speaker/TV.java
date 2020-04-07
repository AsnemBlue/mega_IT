package com.tj.ex10speaker;

public class TV implements IVolume{
	private final int TV_MAX_VOLUME = 30;
	private final int TV_MIN_VOLUME = 0;
	private int volumeLevel;
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV 볼륨을 1만큼 올려 현재"+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못했습니다");
		}		
	}
	@Override
	public void volumeUp(int level) { // 현재 볼륨 25, level이 5
		if(volumeLevel+level <= TV_MAX_VOLUME) {
			volumeLevel += level;
			System.out.println("TV 볼륨을 "+level+"만큼 올려 현재 "+volumeLevel);
		}else { //현재 볼륨이 25, level이 10
			int tempLevel = TV_MAX_VOLUME - volumeLevel;  // tempLevel은 5
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치");
		}
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV 볼륨을 1만큼 내려 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최소치여서 내리지 못했습니다.");
		}
	}
	@Override
	public void volumeDown(int level) { //현재 볼륨이 5, level 4
		if(volumeLevel-level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV 볼륨을 "+level+"만큼 내려 현재 "+volumeLevel);
		}else {  // 현재 볼륨이 5, level이 10
			int tempLevel = volumeLevel;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨 "+level+"만큼 못 내리고 "+tempLevel+"만큼 내려 최소치");
		}
	}
}









