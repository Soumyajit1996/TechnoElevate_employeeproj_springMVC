package com.te.employee_proj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequestDeligationController {
	
	@GetMapping("/redirect")
	public String redirectRequest() {
		return "redirect:http://google.com"; 
	}
	@GetMapping("/forward")
	public String forwardRequest() {
		return "forward:login";
	}
}
