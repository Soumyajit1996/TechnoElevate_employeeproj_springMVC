package com.te.employee_proj.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.employee_proj.beans.EmployeeInfo;
import com.te.employee_proj.service.IEmployeeService;

@Controller
public class EmpMVCController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dataEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
		binder.registerCustomEditor(Date.class, dataEditor);
	}
	
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return"/WEB-INF/views/loginForm.jsp";
	}
	
	@PostMapping("/login")
	public String getLoginFormData(int id,String password,HttpServletRequest req,ModelMap map) {
		EmployeeInfo employeeInfo=empService.authenticate(id,password);
		
		if(employeeInfo!=null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("emp", employeeInfo);
			return "/WEB-INF/views/homePage.jsp";
		}
		else {
			map.addAttribute("errMsg" ,"Invalid Credential");
			return "/WEB-INF/views/loginForm.jsp";
		}
	}

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map,HttpSession session) {
		
		if(session.getAttribute("emp")!=null) {
			return "/WEB-INF/views/searchForm.jsp";
		}
		else {
			map.addAttribute("errMsg","please login first");
			return "/WEB-INF/views/loginForm.jsp";
		}
	}
	
	@GetMapping("/search")
	public String searchEmp(int id,ModelMap map,
			@SessionAttribute(name="emp",required = false)EmployeeInfo employeeInfo ) {
		if(employeeInfo!=null) {
			EmployeeInfo employeeInfo2=empService.getEmployee(id);
			if(employeeInfo2!=null) {
				map.addAttribute("data", employeeInfo2);
			}
			else {
				map.addAttribute("msg", "data not found for id "+id);
			}
			return "/WEB-INF/views/searchForm.jsp";
		}
		else {
			map.addAttribute("errMsg", "please login first");
			return "/WEB-INF/views/loginForm.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("errMsg","Logout Successfully");
		
		return "/WEB-INF/views/loginForm.jsp";
	}
	
	@GetMapping("/deleteForm")
	public String deleteForm(ModelMap map,HttpSession session){
		if(session.getAttribute("emp")!=null) {
			return "/WEB-INF/views/deleteForm.jsp";
		}
		else {
			map.addAttribute("errMsg", "Please Login first");
			return "/WEB-INF/views/deleteForm.jsp";
		}
	}
	
	@GetMapping("/delete")
	public String deleteEmp(int id,@SessionAttribute(name="emp",required = false)
		EmployeeInfo employeeInfo,ModelMap map) {
		if(employeeInfo!=null) {
			boolean result=empService.deleteEmp(id);
			if(result) {
				map.addAttribute("msg","Deleted Successfully");
			}
			else {
				map.addAttribute("errMsg", "Not Deleted Successfully");
			}
			return "/WEB-INF/views/deleteForm.jsp";
		}
		return "/WEB-INF/views/loginForm.jsp";
	}
	
	@GetMapping("/addempForm")
	public String getAddEmpForm() {
		return "/WEB-INF/views/addEmployee.jsp";
	}
	
	@PostMapping("/add")
	public String addEmpDetails(int id,String name,String password,Date dob
			,@SessionAttribute(name="emp", required = false)EmployeeInfo employeeInfo,
			ModelMap map) {
		if(employeeInfo!=null) {
			boolean result=empService.addEmployee(id, name, password, dob);
			if(result) {
				map.addAttribute("msg","Employee Added Successfully");
			}
			else {
				map.addAttribute("errMsg", "Not Added");
			}
			return "/WEB-INF/views/addEmployee.jsp";
		}
		return "/WEB-INF/views/homePage.jsp";
	}
	
	@GetMapping("/allemp")
	public String getAllEmployee(ModelMap map,@SessionAttribute(name="emp",required = false)EmployeeInfo bean) {
		if(bean!=null) {
			List<EmployeeInfo> empList = empService.getAllEmp();
			map.addAttribute("empData",empList);
			return "/WEB-INF/views/allEmpForm.jsp";
		}
		else {
			map.addAttribute("msg", "No employee Found");
			return "/WEB-INF/views/allEmpForm.jsp";
		}
	}
	@GetMapping("/update")
	public String getUpdateForm(@SessionAttribute(name="emp",required=false)EmployeeInfo bean,ModelMap map) {
		if(bean!=null) {
			map.addAttribute("id",bean.getId());
			return "/WEB-INF/views/updateForm.jsp";
		}
		else {
			map.addAttribute("errMsg", "Please Login First");
			return "/WEB-INF/views/loginForm.jsp";
		}
	}
	
	@PostMapping("/update")
	public String updateData(EmployeeInfo employeeInfo,ModelMap map,@SessionAttribute
			(name="emp",required = false)EmployeeInfo bean) {
		if(bean!=null) {
			if(empService.updateEmpdata(employeeInfo)) {
				map.addAttribute("id",bean.getId());
				map.addAttribute("msg", "Updated Successfully");
			}
			else {
				map.addAttribute("msg", "Not able to update");
			}
			return "/WEB-INF/views/updateForm.jsp";
		}
		else {
			map.addAttribute("errMsg", "Please Login First");
			return "/WEB-INF/views/loginForm.jsp";
		}
	}
}
