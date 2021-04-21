package com.te.employee_proj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.employee_proj.beans.EmployeeInfo;
@Repository
public class ImplEmployeeDao implements IEmployeeDao{

	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Override
	public EmployeeInfo authenticate(int id,String password) {
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Employee_Info");
		EntityManager manager=factory.createEntityManager();
		
		EmployeeInfo  bean = manager.find(EmployeeInfo.class, id);
		if(bean!=null) {
			if(bean.getPassword().equals(password)) {
				System.out.println("Login Successfully");
				return bean;
			}
			else {
				System.out.println("Invalid Credential");
				return null;
			}
		}
		else {
			System.out.println("Invalid Credential");
			return null;
		}
	}

	@Override
	public EmployeeInfo getEmployee(int id) {
	//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Employee_Info");
		EntityManager manager=factory.createEntityManager();
		EmployeeInfo employeeInfo=manager.find(EmployeeInfo.class,id);
		return employeeInfo;
	}

	@Override
	public boolean deleteEmp(int id) {
	//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Employee_Info");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		EmployeeInfo bean = manager.find(EmployeeInfo.class ,id);
		manager.remove(bean);
		transaction.commit();
		if(bean!=null) {
			System.out.println("Deleted Successfully");
			return true;
		}
		else {
			System.out.println("Not able to delete");
			return false;
		}
	}

	@Override
	public boolean addEmployee(int id, String name, String password, Date dob) {
	//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Employee_Info");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		EmployeeInfo empObj=new EmployeeInfo();
		empObj.setId(id);
		empObj.setName(name);
		empObj.setPassword(password);
		empObj.setDob(dob);
		if(empObj!=null) {
			manager.persist(empObj);
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<EmployeeInfo> getAllEmployee() {
	//	EntityManagerFactory factory=Persistence.createEntityManagerFactory("Employee_Info");
		EntityManager manager=factory.createEntityManager();
		String data="from EmployeeInfo";
		Query query=manager.createQuery(data);
		List<EmployeeInfo> empList= query.getResultList();
		if(empList!=null) {
			return empList;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean updateEmpdata(EmployeeInfo bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			EmployeeInfo emp= manager.find(EmployeeInfo.class,bean.getId());
			if(bean.getName()!=null&&bean.getName()!="") {
				emp.setName(bean.getName());
			}
			if(bean.getDob()!=null) {
				emp.setDob(bean.getDob());
			}
			if(bean.getPassword()!=null&&bean.getPassword()!="") {
				emp.setPassword(bean.getPassword());
			}
			transaction.commit();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
