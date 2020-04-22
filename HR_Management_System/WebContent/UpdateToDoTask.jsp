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
                <form action="ToDoTaskUpdate" method="post">
                    <span class="label-log">Task Assign</span>

                    <div class="user">
                    
                    <input type="hidden" name="tid" value=<%= request.getParameter("id") %> >

                        <select name="tstatus" class="blood">
                            <%! String tstatus; %>
                            <%                             
                           /*  String tstatus = ""; */                            
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
                            <option value="<%= tas.getTstatus()%>"> <% out.print(tstatus); %> </option>
                            <option value="0">Incomplete</option>
                            <option value="1" > In Progress </option>
                            <option value="2" > Completed </option>
                           
                            
                        </select>
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
