package com.Nicholas.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultServer {

	@RequestMapping("/your_server")
	public String defaultSever() {
		return "<h1>Hello Human!</h1> <p>Welcome to SpringBoot!</p>";
	}
}
