<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.DisplayAllProjectsDao" %>
<%@ page import = "model.Project" %>
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
    <!--        <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <title>Project List</title>
</head>
<body background="BACK.jpg" text="white" class="style_1">
<div class="style">
<font size=1>
<h1 style="
    text-align: center;
    margin:20px;"> <u>Project Details </u></h1>
   
<table border="9"style="border-color: blueviolet">  
 
	<tr>
	
		<th> Project Id </th>
		 
		<th> Project Manager Id    </th>
		
		<th> Project Name          </th>
		
		<th> Client Name           </th>
		
		<th> Programming Language  </th>
		
		<th> DataBase Technology   </th>  
		
		<th> Project Cost          </th>		  
		
		<th> Starting Date         </th>
		
		<th colspan=2> Action      </th>		
	
	</tr>
	
	<%
		List<Project> pList = DisplayAllProjectsDao.displayAllProjects();
		for(Project prj : pList)
		{
	%>
	
	<tr align=center>
		
		<td> <%= prj.getPid() %> </td>
		
		<td> <%= prj.getPmid() %> </td>
		
		<td align=justify> <%= prj.getPname() %> </td>
		
		<td align=justify> <%= prj.getClientname() %> </td>
		
		<td> <%= prj.getProgramminglanguage() %> </td>
		
		<td> <%= prj.getDatabasetechnology() %> </td>
		
		<td> <%= prj.getPcost() %> </td>
		
		<td> <%= prj.getPsdate() %> </td>  
		
    	<td> <a href = "/HR_Management_System/UpdateProject.jsp?id=<%= prj.getPid() %> " > edit </a> </td> 
		
		<td> <a href = "/HR_Management_System/DeleteProjectController?id=<%= prj.getPid() %> " > delete </a> </td>
		
	</tr>
	
	<%  } // for each loop clsoing  %>

</table> <br/> <br/> <br/>
 </font>
 </div>
 Count number of project: <%= DisplayAllProjectsDao.countProject() %>
</body>
</html>
<% } // else of line 14 closed.  %>
