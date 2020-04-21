<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.DisplayAllTaskDao" %>
<%@ page import = "model.Task" %>
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
    <!-- <link rel="stylesheet" href="css/ViewEmployee_style.css"> -->
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--  <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
	<title>View Task</title>

</head>
<body background="BACK.jpg" text="white">

<h1 style="
    text-align: center;
    margin:20px;"> <u>Task List</u> </h1>
    <div class="style">
<font size=1>
<table border="10" style="border-color: blueviolet;"> 
	<tr  align=center>
	
		<th> Task id	</th>
	<!-- <th> Employee id	</th>  -->
		<th> Sender id	</th>
	<!-- <th> Project id	</th> -->
		<th> Project Name	</th>
		<th> Start Date	</th>
		<th> End Date	</th>  
		<th> Priority	</th>
		<th> Description	</th>
		<th> Status	</th>
		<th> Action
		
		
		</th>		
	</tr>
	<%
		List<Task> tList = DisplayAllTaskDao.displayAllToDoTask((int)session.getAttribute("eid"));
		for(Task tas : tList)
		{
	%>
	<tr  align=center>
		
		<td> <%= tas.getTid() %> </td>
		
		<td> <%= tas.getSourceeid() %> </td>
		
	<%-- <td> <%= tas.getPid() %> </td> --%>
		
		<td> <%= tas.getPname() %> </td>
		
		<td> <%= tas.getTsdate() %> </td>
		
		<td> <%= tas.getTedate() %> </td>
		
		<td> <%= tas.getTpriority() %> </td>
		
		<td  align=justify> <%= tas.getTdes() %> </td>
		
		<%
			String tstatus = "";
			if(tas.getTstatus() == 0)
			{
				tstatus = "Incomplete";
			}
			else if(tas.getTstatus()==1)
            {
            	tstatus = "In Progress";
            }
            else
            {
            	tstatus = "Completed";
            }
		%>
		
		<td> <% out.println("tstatus"); %> </td>  
		
		<td> <a href="/HR_Management_System/UpdateToDoTask.jsp?id=<%= tas.getTid() %> "> edit </a> </td>
						
	</tr>
	<%  } // for each loop clsoing  %>
	
</table> <br/> <br/> <br/>

Count Task: <%= DisplayAllTaskDao.countTask((int)session.getAttribute("eid")) %>
</font>
</div>
</body>
</html>
<% } // else of line 14 closed.  %>