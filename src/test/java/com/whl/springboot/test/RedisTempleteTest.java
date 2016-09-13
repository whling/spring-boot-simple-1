package com.whl.springboot.test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whl.springboot.simple.Application;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTempleteTest {

	 @Autowired
	 private RedisTemplate<String, String> redisTemplate;


	/*
	 * @Test public void testString(){ String string =
	 * redisTemplate.boundValueOps("name").get(); System.out.println(string); }
	 */

	@Test
	public void testHash() {
		// Object object = redisTemplate.boundHashOps("user").get("name");
		// System.out.println(object);
		Set<Object> keys = redisTemplate.boundHashOps("user").keys();
		for (Object object : keys) {
			System.out.println(object);
		}
		redisTemplate.boundHashOps("user").expire(30, TimeUnit.SECONDS);
	}
	@Test
	public void testList() {
		BoundListOperations<String,String> listOperations = redisTemplate.boundListOps("myList");
		listOperations.rightPush("a");
		listOperations.rightPush("b");
		listOperations.rightPush("c");
		listOperations.rightPush("d");
		String leftPop = redisTemplate.opsForList().leftPop("myList");
		System.out.println(leftPop);
		String leftPop2 = redisTemplate.boundListOps("myList").leftPop();
		String leftPop3 = redisTemplate.opsForList().leftPop("myList");
		System.out.println(leftPop2);
		System.out.println(leftPop3);
	}

}
