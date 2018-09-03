package com.sws.hdmshull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HdmsHullApplication {
	@RequestMapping("/")
	@ResponseBody
	public String showIndex(){
		return "hello,hdms";
	}
	public static void main(String[] args) {
		SpringApplication.run(HdmsHullApplication.class, args);
	}
}
