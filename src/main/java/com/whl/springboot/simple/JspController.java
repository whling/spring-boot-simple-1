package com.whl.springboot.simple;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	@RequestMapping("/hellojsp")
	public String hellojsp(Map<String, Object> map){
		map.put("hello", "hello whling");
		return "hello";
	}
}
