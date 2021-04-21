package com.te.employee_proj.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookiesController {
	@GetMapping("/cookiesPage")
	public String getCookies() {
		return "/WEB-INF/views/cookiesPage.jsp";
	}
	@GetMapping("/createCookie")
	public String name(HttpServletResponse response,ModelMap map) {
		Cookie cookie=new Cookie("EmpName","Sai");
		response.addCookie(cookie);
		map.addAttribute("msg", "created Cookies");
		return "/WEB-INF/views/cookiesPage.jsp";
	}
	
	@GetMapping("/showCookies")
	public String showCookies(@CookieValue(name="EmpName",required = false)String name,ModelMap map) {
		map.addAttribute("cookie", name);
		return "/WEB-INF/views/cookiesPage.jsp";
	}
}
