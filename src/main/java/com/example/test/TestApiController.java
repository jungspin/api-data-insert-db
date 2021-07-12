package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController -> return 하면 문자 그대로 출력
@Controller
public class TestApiController {
	


	@GetMapping("/")
	public String home() {

	
		return "home";
			
			
	}
}
