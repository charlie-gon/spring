package com.company.yedam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.yedam.di.AppleSpeaker;
import com.company.yedam.di.LgTV;
import com.company.yedam.di.SamsungTV;
import com.company.yedam.di.SonySpeaker;
import com.company.yedam.di.Speaker;
import com.company.yedam.di.Tv;

//@Configuration
public class AppConfig { // 교재 p.90

	// LG TV / Sony Speaker
//	@Bean
//	public Speaker speaker() {
//		return new SonySpeaker();
//	}
//	
//	@Bean
//	public Tv tvService() {
//		LgTV tv = new LgTV();
//		tv.setSpeaker(speaker());
//		return tv;
//	}
	
	// Samsung Tv/Apple Speaker
	@Bean
	public Speaker speaker() {
		return new AppleSpeaker();
	}
	
	@Bean
	public Tv tvService() {
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker());
		return tv;
	}
	
	
}
