package com.test.myspring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.myspring.service.UserService;
import com.test.myspring.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring-mysql-db.xml")
public class MyTest {
	@Autowired
	UserService userService;
	@Test
	public void test1() {
		UserVo userVo = new UserVo();
		userVo.setUsername("zhuguang");
		userVo.setPassword("123456");
		userVo.setSex(1);
		userService.addUser(userVo);
	}
	@Test
	public void findUser() {
		List<UserVo> users = userService.findUsers();
		System.out.println("list:"+users);
	}
}
