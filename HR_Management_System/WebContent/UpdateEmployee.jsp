<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.UpdateEmployeeDao" %>
<%@ page import = "model.Register" %>
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
	<meta charset="ISO-8859-1">
 	<meta charset="UTF-8">
    <title>Employee Registration </title>
    <link rel="stylesheet" href="css/registration_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--        <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
<title>Update Employee Information</title>
</head>

<body background="BACK.jpg">
	 <div class="head">
        <div class="main-head">
            <div class="form-sec">

<% Register reg = UpdateEmployeeDao.getData(Integer.parseInt(request.getParameter("eid"))); %>
                <form action="EmployeeUpdate" method="post" name="UpdateEmployee">
                    <span class="label-log"> Employee Information Update  </span>

                    <div class="user">

                        <input type="hidden" name="eid" placeholder="Enter Employee ID" value="<%= reg.getEid() %>" required>
                    </div>

                    <div class="user">

                        <input type="hidden" name="logid" placeholder="Enter Login ID" value="<%= reg.getLogid() %>" required>
                    </div>

                    <div class="user">

                        <input type="number" name="rid" placeholder="Enter Role ID" value="<%= reg.getRid() %>" required>
                    </div>

                    <div class="user">
                        <input type="text" name="ename" placeholder="Enter Name" value="<%= reg.getEname() %>" required>
                    </div>

                    <div class="user">
                        <input type="text" name="eadd" class="add" placeholder="Enter Address" value="<%= reg.getEadd() %>" required>
                    </div>

                    <div class="user">
                    
                        <input type="text" name="emno" placeholder="Enter Mobile NO." maxlength="10" value="<%= reg.getEmno() %>" required>
                    </div>
                    <div class="user">
                        <input type="email" name="eemail" placeholder="Enter Email Address" value="<%= reg.getEemail() %>" required>
                    </div>
                    <div class="user">
                        <input type="password" name="password" placeholder="Type Your Password" value="<%= reg.getPassword() %>" required>
                    </div>

                    <div class="user">
                        <input type="text" name="edob" placeholder="Enter Date Of Birth" onfocus="(this.type='date')" onblur="(this.type='date')" value="<%= reg.getEdob() %>" required>
                    </div>

                    <div class="user">
                        <input type="radio" name="egender" value="male" required> <span class="text">Male</span>
                        <input type="radio" name="egender"value="female"> <span class="text_1">Female</span>
                    </div>

                    <div class="user">
                        <input type="text" name="city" placeholder="Enter City" value="<%= reg.getCity() %>" required>
                    </div>

                    <div class="user">
                        <input type="text" name="state" placeholder="Enter State" value="<%= reg.getState() %>" required>
                    </div>

                    <div class="user">
                        <select name="bloodgroup" class="blood" required>
                           <option value="<%= reg.getBloodgroup() %>"><%= reg.getBloodgroup() %></option> 
                            <option value="A+">A+</option>  
                            <option value="O+">O+</option>  
                            <option value="B+">B+</option>  
                            <option value="AB+">AB+</option> 
                            <option value="A-">A-</option> 
                            <option value="O-">O-</option> 
                            <option value="B-">B-</option> 
                            <option value="AB-">AB-</option> 
                        </select> 
                    </div> 

                    <div class="forgot"> 
                        <input type="reset" class="cancelbtn"> 

                    </div> 
                    <div class="button-cont"> 
                        <button class="log"> 
                            Update </button> 
                    </div> 

                </form> 
            </div> 
        </div> 
    </div> 

</body>
</html>
<% } // else of line 14 closed.  %>