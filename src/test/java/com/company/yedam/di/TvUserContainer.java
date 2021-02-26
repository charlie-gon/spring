package com.company.yedam.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		Tv tv = (Tv)factory.getBean(Tv.class); // class 타입으로 검색
		//Tv tv = (Tv)factory.getBean("tv"); // name/id로 검색
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
