<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.UpdateTaskDao" %>
<%@ page import = "model.Task" %>
<%@ page import = "java.lang.*" %>
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
	<meta charset="UTF-8">
	<meta charset="ISO-8859-1">
    <title> Update Task </title>
    <link rel="stylesheet" href="css/assigntask_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--        <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
</head>
<body background="BACK.jpg">
 <div class="head">
        <div class="main-head">
            <div class="form-sec">
<% Task tas = UpdateTaskDao.updateTask(Integer.parseInt(request.getParameter("id"))); %>
                <form action="TaskUpdate" method="post">
                    <span class="label-log">Task Assign</span>
                    <div class="user">                    
                    <input type="hidden" name="tid" value=<%= request.getParameter("id") %> >
                        <select name="destinationEname" class="blood">                            
                            <option value="<%= tas.getDestinationEname()%>"><%= tas.getDestinationEname() %></option>
                            <option value="Patel Kishan">Patel Kishan</option>
                            <option value="Nathani Rahul" > Nathani Rahul </option>
                            <option value="Patel Meera" > Patel Meera </option>
                            <option value="Jain Shakshi" > Jain Shakshi </option>
                            <option value="Vadgama Krushanu">Vadgama Krushanu</option>
                            <option value="Sathwara Dhananjay"> Sathwara Dhananjay </option>
                            <option value="Gajjar Vishv">Gajjar Vishv</option>
                            <option value="Sathwara Jenil"> Sathwara Jenil </option>
                            <option value="Parmar Vedant"> Parmar Vedant </option>                    
                        </select>
                    </div>
                    <div class="user">
                        <select name="pname" class="blood">
                            <option value="<%= tas.getPname() %>"><%= tas.getPname() %></option>
                            <option value="Humsn Capital Management System">Human Capital Management System</option>
                            <option value="Aurum Sky">Aurum Sky</option>
                        </select>
                    </div>
                    <div class="user_1">
                        <input type="text" name="tsdate" placeholder="Starting Date of Task"
                            onfocus="(this.type='date')" onblur="(this.type='date')" value="<%= tas.getTsdate() %>" required>
                    </div>


                    <div class="user_1">
                        <input type="text" name="tedate" placeholder="Ending Date of Task" onfocus="(this.type='date')"
                            onblur="(this.type='date')" value="<%= tas.getTedate() %>" required>            </div>
                    <div class="user">
                        <select name="tpriority" class="blood">
                            <option value="<%= tas.getTpriority() %> "><%= tas.getTpriority() %></option>
                            <option value="high">High</option>
                            <option value="middle">Middle</option>
                            <option value="low">Low</option>
                        </select>
                    </div>
                    <div class="user">
                        <input type="text" name="tdes" placeholder="Task Descripton" value="<%= tas.getTdes() %>" required>
                    </div>
                    <div class="button-cont">
                        <button class="log">
                            Update Task </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
<% } // else of line 14 closed.  %>