package com.whl.springboot.simple;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "redis", locations = "classpath:config/redis.properties")
public class Example {
	private static Logger logger = LoggerFactory.getLogger(Example.class);

	@Autowired
	private UserService userService;

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@RequestMapping("/hello/{myName}")
	User index(@PathVariable String myName) {
		logger.debug("访问helloName,name={}", myName);
		User user = new User();
		System.out.println(url);
		user.setId(1);
		user.setName(myName);
		user.setBirthday(new Date());
		userService.save(user);
		return user;
	}

	/* * 通过springjdbc连接数据库 */
	@RequestMapping("/{id}")
	User getUserById(@PathVariable Integer id) {
		User user = userService.getUserById(id);
		return user;
	}
	/* 从缓存中清除数据 */
	@RequestMapping("/delete")
    public @ResponseBody String delete(Integer id){
		userService.delFromCache(id);
        return"ok";
    }

	@RequestMapping("/userList")
	List<User> getById() {
		List<User> users = userService.getById();
		return users;
	}
}
