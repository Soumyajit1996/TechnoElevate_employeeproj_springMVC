package com.te.employee_proj.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employeeinfo")
public class EmployeeInfo implements Serializable{
	
	@Id
	@Column(name="emp_id")
	private Integer id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column
	private String password;
	
	@Column
	private Date dob;
}
