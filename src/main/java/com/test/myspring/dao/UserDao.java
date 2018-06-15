package com.test.myspring.dao;

import java.util.List;

import com.test.myspring.vo.UserVo;

public interface UserDao {
	public List<UserVo> findUsers();
	public Integer addUser(UserVo userVo);
}
