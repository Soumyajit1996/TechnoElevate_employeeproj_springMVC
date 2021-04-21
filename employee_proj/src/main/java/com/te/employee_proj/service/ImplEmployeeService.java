package com.te.employee_proj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.te.employee_proj.beans.EmployeeInfo;
import com.te.employee_proj.dao.IEmployeeDao;
import com.te.employee_proj.dao.ImplEmployeeDao;
@Service
public class ImplEmployeeService implements IEmployeeService{

	@Autowired
	IEmployeeDao empDao;
	
	@Override
	public EmployeeInfo authenticate(int id, String password) {
		return empDao.authenticate(id, password);
	}

	@Override
	public EmployeeInfo getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		return empDao.deleteEmp(id);
	}

	@Override
	public boolean addEmployee(int id, String name, String password, Date dob) {
		return empDao.addEmployee(id, name, password, dob);
	}

	@Override
	public List<EmployeeInfo> getAllEmp() {
		return empDao.getAllEmployee();
	}

	@Override
	public boolean updateEmpdata(EmployeeInfo bean) {
		return empDao.updateEmpdata(bean);
	}

}
