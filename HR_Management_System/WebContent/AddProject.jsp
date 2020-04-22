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


                <form action = "AddProject" method = "post" name = "Add Project">
                    <span class="label-log">ADD PROJECT</span>

                    <div class="user">
                        <input type="number" name="pmid" placeholder="Enter project Manager ID" required>
                    </div>

                    <div class="user">

                        <input type="text" name="pname" placeholder="Enter project name" required>
                    </div>
                    
                    <div class="user">

                        <input type="text" name="clientname" placeholder="Enter client name" required>
                    </div>                    

                    <div class="user">

                        <select name="programminglanguage" class="blood" required>
                            <option value="">Select project programming language</option>
                            <option value="java">Java</option>
                            <option value="php">PHP</option>
                            <option value="python">Python</option>
                            <option value="android">Android</option>
                            <option value="c/c++">C/C++</option>
                            <option value="c#">C#</option>
                            <option value="flutter">Flutter</option>
                            <option value="asp.net">ASP.NET</option>
                            <option value="swift">Swift</option>
                            <option value="ruby">Ruby</option>
                        </select>
                    </div>

                    <div class="user">

                        <select name="databasetechnology" class="blood" required>
                            <option value="">Select DataBase Technology</option>
                            <option value="oracle">Oracle</option>
                            <option value="mysql">MySql</option>
                            <option value="nosql">NoSql</option>
                            <option value="postgrag">Post Gray</option>
                            <option value="sqlite">SqLite</option>
                        </select>
                    </div>
                    
                     <div class="user">
                        <input type="number" name="pcost" placeholder="Enter project estimated cost (in Rs.)" required>
                    </div>
                    
                  <div class="user">
              		<input placeholder="Enter starting date of Project" type="text" name="status" onfocus="(this.type='date')" onblur="(this.type='date')"  required>
              		</div>                      
                    
                    
                    <div class="user_1">
                        
                       <input placeholder="Enter estimated ending date of Project" type="text" name="status" onfocus="(this.type='date')" onblur="(this.type='date')" required>
              
                    </div>
                    
                       <div class="user">
                        <input type="text" name="pdes"  placeholder="Write project description" required>
                    </div>
                       
                     <div class="forgot">
                        <input type="reset" class="cancelbtn">
                    </div>	
                 				
                    <div class="button-cont">
                        <button class="log">
                            Add  Project </button>
                    </div>

                </form> 
            </div> 
        </div>
    </div>	

</body>
</html>
<% } // else of line 14 closed.  %>