package com.whl.springboot.simple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUserById(Integer id) {
		String sql = "select * from user where id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> list = jdbcTemplate.query(sql, rowMapper, id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
