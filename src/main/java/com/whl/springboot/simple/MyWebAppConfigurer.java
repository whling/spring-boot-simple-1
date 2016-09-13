package com.whl.springboot.simple;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置自定义拦截器
 * 
 * @author Administrator
 *
 */
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/hello/**");
		super.addInterceptors(registry);
	}

}
