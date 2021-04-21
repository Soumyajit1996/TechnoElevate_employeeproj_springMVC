<%@page import="com.te.employee_proj.beans.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% String msg=(String)request.getAttribute("errMsg"); %>
<% EmployeeInfo bean=(EmployeeInfo)request.getAttribute("data"); %>
<%@ include file="headerForm.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form</title>
</head>

<body>

	<% if(msg!=null && !msg.isEmpty()) {%>
		<h1><%=msg%></h1>
	<% } %>

	<form action="./search" method="get">
		<fieldset>
			<legend>Search</legend>		
			<table>
				<tr>
					<td>Enter the user_id</td>
					<td> <input type="text" name="id"> </td>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<% if(bean!=null) {%>
	 	<h3>User_Id: <%= bean.getId() %></h3>
		<h3>User_Name: <%= bean.getName() %></h3>
		<h3>User_DOB: <%= bean.getDob() %></h3>
	<% } %>
</body>
</html>