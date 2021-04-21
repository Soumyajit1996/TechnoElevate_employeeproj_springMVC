<%@page import="com.te.employee_proj.beans.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String msg= (String)request.getAttribute("msg"); %>
<% List<EmployeeInfo> empList=(List)request.getAttribute("empData"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Data</title>
</head>
<body>
<% if(msg!=null && !msg.isEmpty()) {%>
<%=msg %>
<% } %>
	<fieldset>
		<legend>All Employee</legend>
		<form action="./allemp" method="get">
			<table>
				<tr>
					<td>Employe_ID</td>
					<td>Employee_Name</td>
					<td>Date Of Birth</td>
				</tr>			
				<% for(EmployeeInfo empInfo:empList){
				%>
				<tr>
					<td><%= empInfo.getId() %></td>
					<td><%=empInfo.getName() %></td>
					<td><%=empInfo.getDob() %></td>
				</tr>
				<% } %>
			</table>
		</form>	
	</fieldset>
</body>
</html>