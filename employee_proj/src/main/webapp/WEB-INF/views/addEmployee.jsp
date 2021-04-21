<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String msg=(String)request.getAttribute("msg"); 
	String errmsg=(String)request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Form</title>
</head>
<body>

	<%if(msg!=null&&!msg.isEmpty()) {%>
		<h1><%=msg %></h1>
	<% } %>
	
	<%if(errmsg!=null&&!errmsg.isEmpty()) {%>
		<h1><%=msg %></h1>
	<% } %>
	<form action="./add" method="post">
		<h1>Enter the details for the Employee</h1>
		<table>
			<tr> 
				<td>User_ID</td>
				<td> : </td>
				<td> <input type="text" name="id"> </td>
			</tr>
			
			<tr> 
				<td>User_Name</td>
				<td> : </td>
				<td><input type="text" name="name"> </td>
			</tr>
			
			<tr> 
				<td>Password</td>
				<td> : </td>
				<td> <input type="password" name="password"> </td>
			</tr>
			
			<tr> 
				<td>Date Of Birth</td>
				<td> : </td>
				<td> <input type="date" name="dob"> </td>
			</tr>
			
			<tr> 
				<td><input type="submit" name="submit"> </td>
			</tr>	
		</table>
	</form>
</body>
</html>