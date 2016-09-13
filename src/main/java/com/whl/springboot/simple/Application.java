package com.whl.springboot.simple;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
// mybatis的扫描包
@MapperScan(basePackages = "com.whl.springboot.*")
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	/***
	 * 对上传文件进行一些配置
	 * 
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("128KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("256KB");
		// Sets the directory location where files will be stored.
		factory.setLocation("D://test");
		return factory.createMultipartConfig();
	}
}
