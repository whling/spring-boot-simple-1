package com.whl.springboot.simple;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("select * from user where id = #{id}")
	public User getById(Integer id);
	
	@Select("select * from user")
	public List<User> getUserList();
}
