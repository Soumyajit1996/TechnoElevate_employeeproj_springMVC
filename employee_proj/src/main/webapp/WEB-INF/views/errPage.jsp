<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%String msg=(String)request.getAttribute("err"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<%if(msg!=null && !msg.isEmpty()) {%>
		<%=msg %>
	<%} %>
</body>
</html>