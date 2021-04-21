package com.te.employee_proj.dao;

import java.util.Date;
import java.util.List;

import com.te.employee_proj.beans.EmployeeInfo;

public interface IEmployeeDao {
	public EmployeeInfo authenticate(int id,String password);
	 public EmployeeInfo getEmployee(int id);
	 public boolean deleteEmp(int id);
	 public boolean addEmployee(int id,String name,String password,Date dob);
	 public List<EmployeeInfo> getAllEmployee();
	 public boolean updateEmpdata(EmployeeInfo bean);
}

