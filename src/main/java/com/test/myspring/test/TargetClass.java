package com.test.myspring.test;

import org.springframework.stereotype.Component;

@Component
public class TargetClass {
	public String joint(String s1,String s2) {
		return s1+"+"+s2;
	}
}
