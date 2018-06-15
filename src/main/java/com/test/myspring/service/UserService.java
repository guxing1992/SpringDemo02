package com.test.myspring.service;

import java.util.List;

import com.test.myspring.annotation.TargetDataSorce;
import com.test.myspring.vo.UserVo;
/**
 * 数据库读和写操作数据库应该不一样，这样可以读写分离
 * @author Zhang
 *
 */
public interface UserService {
	@TargetDataSorce("read")
	public List<UserVo> findUsers();
	@TargetDataSorce("write")
	public void addUser(UserVo userVo);
}
