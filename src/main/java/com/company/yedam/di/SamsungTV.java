package com.company.yedam.di;

public class SamsungTV implements Tv{
	
	Speaker speaker;

	public SamsungTV() {}
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}
	
	// 교재 p.80
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
