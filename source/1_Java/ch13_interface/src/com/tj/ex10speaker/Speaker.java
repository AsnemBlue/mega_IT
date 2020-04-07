package com.tj.ex10speaker;
public class Speaker implements IVolume{
	private final int SPEAKER_MAX_VOLUME = 20;
	private final int SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	public Speaker(int volumeLevel) { // IVolume s = new Speaker(3);
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		volumeLevel++;
		if(volumeLevel >= SPEAKER_MAX_VOLUME) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨의 최대치입니다.");
		}else {
			System.out.println("스피커 볼륨 1만큼 올려 현재 레벨이 "+volumeLevel);
		}
	}
	@Override
	public void volumeUp(int level) {
		volumeLevel += level;
		if(volumeLevel >= SPEAKER_MAX_VOLUME ) {
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨이 최대치 입니다");
		}else {
			System.out.println("스피커 볼륨 "+level+"만큼 올려 현재 레벨이 "+volumeLevel);
		}
	}
	@Override
	public void volumeDown() {
		volumeLevel--;
		if(volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨이 최소치입니다.");
		}else {
			System.out.println("스피커 볼륨 1만큼 내려 현재 레벨이 "+volumeLevel);
		}
	}
	@Override
	public void volumeDown(int level) {
		volumeLevel -= level;
		if(volumeLevel <= SPEAKER_MIN_VOLUME) {
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨이 최소치입니다.");
		}else {
			System.out.println("스피커 볼륨 "+level+"만큼 내려 현재 레벨이 "+volumeLevel);
		}
	}
}



