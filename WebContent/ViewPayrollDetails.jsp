<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.DisplayPayrollDao" %>
<%@ page import = "model.Payroll" %>
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
    <link rel="stylesheet" href="css/Common_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--       <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
	<title>View Payroll Details</title>
</head>
<body background="BACK.jpg" text="white" class="style_1">
<div class="style">
<font size=1>
<h1 style="
    text-align: center;
    margin:20px;"> <u> Payroll Details </u></h1>
   
 <table border="9"style="border-color: blueviolet;"> 
 
	<tr >
	
		<th> Payroll Id </th>
		 
		<th> Employee Id    </th>
		
		<th> Payroll type          </th>
		
		<th> Payroll Amount           </th>
		
		<th> Payroll Date </th>
		
		<th> Payroll Month   </th>  	  
		
		<th colspan=2> Action      </th>		
	
	</tr>
	
	<%
		List<Payroll> payList = DisplayPayrollDao.displayPayrollDetails();
	
		for(Payroll pay : payList)
		{
	%>
	
	<tr align="center">
		
		<td> <%= pay.getPayrollid() %> </td>
		
		<td> <%= pay.getEid() %> </td>
		
		<td> <%= pay.getPayrolltype() %> </td>
		
		<td> <%= pay.getAmount() %> </td>
		
		<td> <%= pay.getPayrolldate() %> </td>
		
		<td> <%= pay.getPayrollmonth() %> </td> 
		
    	<td> <a href = "/HR_Management_System/UpdatePayroll.jsp?id=<%=pay.getPayrollid()%>" > edit </a> </td> 
		
		<td> <a href = "/HR_Management_System/DeletePayrollController?id=<%= pay.getPayrollid() %> " > delete </a> </td>
		
	</tr>
	
	<%  } // for each loop clsoing  %>

</table> <br/> <br/> <br/>
 </font>
 </div>
 Count number of:<%= DisplayPayrollDao.countPayroll() %>
</body>
</html>
<% } // else of line 14 closed.  %>
