package com.whl.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.whl.springboot.simple.Application;
import com.whl.springboot.simple.UserService;

/*/// SpringJUnit支持，由此引入Spring-Test框架支持！*/
@RunWith(SpringJUnit4ClassRunner.class)
///  指定我们SpringBoot工程的Application启动类
@SpringBootTest(classes=Application.class)
///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testUser(){
		Assert.assertEquals("whling", userService.getUserById(1).getName());
		System.out.println("test");
	}
}
