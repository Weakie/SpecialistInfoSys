package com.weakie.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringBeanUtil {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); 
	
	public static Object getBeans(String name){
		return ctx.getBean(name);
	}
}
