package com.tg.javabrainsunit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String systemUp() {
		return "System is running!";
	}

}
