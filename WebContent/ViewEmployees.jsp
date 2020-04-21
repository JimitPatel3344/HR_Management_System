<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.DisplayAllEmployeesDao" %>
<%@ page import = "model.Register" %>
<%@ page import = "java.util.List" %>

<% 
	if(session.getAttribute("eid") == null )
	{
		response.sendRedirect("Login.jsp");
	}
	else
	{
%> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="UTF-8">
    <!-- <link rel="stylesheet" href="css/ViewEmployee_style.css"> -->
    <link rel="stylesheet" href="css/Common_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--  <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
	<title>View Employees</title>
</head>
<body background="BACK.jpg" text="white">
<div class="style">
<font size=1>
<h3 style="
    text-align: center;
    margin:20px;"> <u>Employee Details </u> </h3>

<table border="9"style="border-color: blueviolet;"> 
	<tr>
	
		<th> Employee id
		</th>
		<th> Login id
		</th>
		<th> Role id
		</th>
		<th> Name
		</th>
		<th> Mobile number
		</th>
		<th> E-mail id
		</th>  
		<th colspan=2> Action
		</th>		
	</tr>
	<%
		List<Register> eList = DisplayAllEmployeesDao.displayAllEmployees();
		for(Register reg : eList)
		{
	%>
	<tr>
		
		<td> <%= reg.getEid() %> </td>
		
		<td> <%= reg.getLogid() %> </td>
		
		<td> <%= reg.getRid() %> </td>
		
		<td> <%= reg.getEname() %> </td>
		
		<td> <%= reg.getEmno() %> </td>
		
		<td> <%= reg.getEemail() %> </td>  
		
		<td> <a href="/HR_Management_System/UpdateEmployee.jsp?eid=<%= reg.getEid() %> "> edit </a> </td>
		
		<td> <a href="/HR_Management_System/DeletEmployee?id=<%= reg.getEid() %> "> delete </a> </td>
		
	</tr>
	<%  } // for each loop clsoing  %>
	
</table> <br/> <br/> <br/>
</font>
</div>
Count Employee: <%= DisplayAllEmployeesDao.countEmployee() %>
</body>
</html>
<% } // else of line 14 closed.  %>
