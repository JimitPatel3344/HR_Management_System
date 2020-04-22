<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("VisitCount") == null ) 
		session.setAttribute("VisitCount", 1) ;		
else
{
	// int count = (int)session.getAttribute("VisitCount") + 1 ;
	session.setAttribute("VisitCount", (int)session.getAttribute("VisitCount") + 1) ;
}
%> 
<h1> You have visited this site <%= session.getAttribute("VisitCount") %> </h1>
</body>
</html>