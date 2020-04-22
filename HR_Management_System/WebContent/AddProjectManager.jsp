<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
    <link rel="stylesheet" href="css/project_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <title> Add Project </title>
</head>

<body background="BACK.jpg">
    <div class="head">
        <div class="main-head">
            <div class="form-sec">


                <form action = "AddProjectManager" method = "post" name = "Add Project Manager">
                    <span class="label-log">ADD PROJECT</span>

                    <div class="user">
                        <input type="number" name="pmid" placeholder="Enter project manager ID" required>
                    </div>

                    <div class="user">
                        <input type="number" name="eid" placeholder="Enter employee ID" required>
                    </div>
                    			
                    <div class="button-cont">
                        <button class="log">
                            Add  Project Manager </button>
                    </div>

                </form> 
            </div> 
        </div>
    </div>	

</body>
</html>
<% } // else of line 14 closed.  %>