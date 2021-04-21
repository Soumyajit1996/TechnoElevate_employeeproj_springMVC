<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<%
String errmsg = (String) request.getAttribute("errMsg");
%>
<%
int id = (int) request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1><%=msg%></h1>
	<%
	}
	%>
	<%
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<%=errmsg%>
	<%
	}
	%>
	<fieldset>
		<legend>Update Form</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>User Id : <%=id%></td>
					<td><input type="number" name="id" value="<%=id%>"
						hidden="true"></td>
				</tr>

				<tr>
					<td>User_Name</td>
					<td>:</td>
					<td><input type="text" name="name"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td>Date Of Birth</td>
					<td>:</td>
					<td><input type="date" name="dob"></td>
				</tr>

				<tr>
					<td><input type="submit" value="SubmitUpdate"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>