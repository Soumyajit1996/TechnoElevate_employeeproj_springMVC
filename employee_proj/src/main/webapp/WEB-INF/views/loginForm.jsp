<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%String msg= (String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<% if(msg!=null && !msg.isEmpty()){ %>
	<h1><%=msg %></h1>
	<% } %> 
	<fieldset>
		<legend>Login Form</legend>
		<form action="./login" method="post">
			<table>
			<tr>
				<td>User Id</td>
				<td> : </td>
				<td> <input type="text" name="id"> </td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td> : </td>
				<td> <input type="password" name="password">  </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		</form>
	</fieldset>
</body>
</html>