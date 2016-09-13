package com.whl.springboot.simple;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public void exceptionHandler(HttpServletRequest req, Exception e){
		e.printStackTrace();
		System.out.println("GlobleExceptionHandler hand exception");
	}
}
