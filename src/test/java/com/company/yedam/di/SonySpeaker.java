package com.company.yedam.di;

import org.springframework.stereotype.Component;

@Component("sony") // 닉네임으로 bean 등록 가능
public class SonySpeaker implements Speaker {
	public SonySpeaker(){
		System.out.println("SonySpeaker 생성");
	}
	public void volumeUp(){
		System.out.println("SonySpeaker 소리 올림");
	}
	public void volumeDown(){
		System.out.println("SonySpeaker 소리 내림");
	}	
}
