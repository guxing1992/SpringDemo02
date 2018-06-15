package com.test.myspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myspring.dao.UserDao;
import com.test.myspring.service.UserService;
import com.test.myspring.vo.UserVo;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public List<UserVo> findUsers() {
		// TODO Auto-generated method stub
		List<UserVo> users = userDao.findUsers();
		System.out.println(users.size());
		return users;
	}

	@Override
	public void addUser(UserVo userVo) {
		// TODO Auto-generated method stub
		Integer i = userDao.addUser(userVo);
		System.out.println("insert success:"+i);
	}

}
