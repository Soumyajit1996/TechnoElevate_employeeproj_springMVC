<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String data=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<body>

	<%if(data!=null&&!data.isEmpty()){ %>
		<h1><%=data %></h1>
	<% } %> 
	<fieldset>
		<legend>Delete</legend>
		<form action="./delete" method="get">
		<table>
			<tr>
				<td>Enter the Emp_ID</td>
				<td> : </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td> <input type="submit" name="submit"> </td>
			</tr>
		</table>
	</form>
	</fieldset>
</body>
</html>