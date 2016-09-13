package com.whl.springboot.simple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserMapper userMapper;
	
	

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Cacheable(value="user")
	public User getUserById(Integer id) {
		System.out.println("从数据库中取出数据");
		User user = userDao.getUserById(id);
		return user;
	}
	@CacheEvict(value="user")
	public void delFromCache(Integer id){
		System.out.println("从缓存中清除");
	}

	public List<User> getById() {
		PageHelper.startPage(0, 5);
		List<User> userList = userMapper.getUserList();
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		System.out.println(pageInfo.getTotal());
		return userList;
	}
}
