package com.springlec.spring0303;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//configLocation : 스프링 컨테이너다...
		String configLocation = "classpath:appCTX.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		
		MyInfo myInfo = ctx.getBean("myinfo", MyInfo.class);
		myInfo.getInfo();
		ctx.close();
		
	}

}
