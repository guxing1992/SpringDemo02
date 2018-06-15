package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.myspring.test.TargetClass;

public class TestAop {
	@Test
	public void testAOP() {
		// 1、创建Spring的IOC的容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean.xml");

		// 2、从IOC容器中获取bean的实例
		TargetClass targetClass = (TargetClass) ctx.getBean("targetClass");

		// 3、使用bean
		String result = targetClass.joint("spring", "aop");
		System.out.println("result:" + result);
	}
}
