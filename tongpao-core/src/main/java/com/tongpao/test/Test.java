package com.tongpao.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: Test</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/25 0:00
 */
public class Test {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Test.class);
		logger.info("你妹呀！");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = applicationContext.getBean("student", Student.class);
		System.out.println("student:" + student);
		System.out.println("student:" + student.getName() + ",age:"+student.getAge());
	}
}
