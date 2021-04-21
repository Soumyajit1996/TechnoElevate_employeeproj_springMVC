package com.te.employee_proj.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.employee_proj.custome_exception.EmployeeExp;

@ControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeExp.class)
	public String handleExp(EmployeeExp exp,HttpServletRequest req) {
		req.setAttribute("err", exp.getMessage());
		return "/WEB-INF/views/errPage.jsp";
	}
}
