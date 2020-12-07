package com.Nicholas.GettingFamiliarwithRouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	
	@RequestMapping("/coding")
	public String controllerOne() {
		return "Hello Coding Dojo!";
	}

	@RequestMapping("/coding/python")
	public String controllerTwo() {
		return "Python/Django was awesome!";
	}

	@RequestMapping("/coding/python/java")
	public String controllerThree() {
		return "Java/Spring is better!";
	}
}
