package com.whl.springboot.simple;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = "/druid/*", initParams = { 
																														// (没有配置或者为空，则允许所有访问)
		 // IP黑名单
																// (存在共同时，deny优先于allow)
		@WebInitParam(name = "loginUsername", value = "admin"), // 用户名
		@WebInitParam(name = "loginPassword", value = "123456"), // 密码
		@WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset
															// All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;

}