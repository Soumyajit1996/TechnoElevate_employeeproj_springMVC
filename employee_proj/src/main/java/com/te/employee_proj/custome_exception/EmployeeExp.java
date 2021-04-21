package com.te.employee_proj.custome_exception;

public class EmployeeExp extends RuntimeException{
	public EmployeeExp(String msg) {
		super(msg);
	}
}
