 
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
<html lang="en">
<head>
    <meta charset="UTF-8" >
    <title>LOGIN  PAGE</title>
    <link rel="stylesheet" href="css/login_style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<!--        <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
</head>
<body background="BACK.jpg">
    <div class="head">
        <div class="main-head">
            <div class="form-sec">


                <form action="ForgotPassword" method="post" name="ForgotPassword">
                    <span class="label-log">Create new password</span>
                    
                    <div class="user">
                        <!-- <span class="user-data">Email ID</span> -->
                        <input type="text" name="eemail" placeholder="Enter your email id" title="Email ID can not be left blank." required />
                      
                        <span class="zmdi zmdi-account-o user-icon"></span>
                    </div>
                    
                    <div class="user">
                        <span class="user-data">Employee ID</span>

                        <input type="number" name="eid" placeholder="Enter your employee ID" title="Employee ID can not be left blank." required />
                        <span class="zmdi zmdi-account-o user-icon"></span>
                    </div>
                    
                      <div class="user">
                        <span class="user-data">Password</span>
                        <input type="password" name="password" placeholder="Enter your name" title="Password can not be left blank." required />
                        <span class="zmdi zmdi-lock-outline user-icon"></span>
                    </div>
                    
                     <div class="user">
                        <span class="user-data">Name</span>
                        <input type="text" name="ename" placeholder="Enter your password" title="Name can not be left blank." required />
                        <span class="zmdi zmdi-lock-outline user-icon"></span>
                    </div>
                    
                   <div class="button-cont">
                        <button class="log">
                            Update </button> 
                            
                 <!--   <input type="submit" name="login" class="log" Value="Login" required />
                   -->   </div>
<!--
                    <div class="text-line">
                        Or Sign Up Using</div>
                    <div class="icon-imgs">
                        <a href="" class="icon-com fb">
                            <span class="fab fa-facebook-f"></span>
                        </a>
                        <a href="" class="icon-com tw">
                            <span class="fab fa-twitter"></span>
                        </a>
                        <a href="" class="icon-com you">
                            <span class="fab fa-google"></span>
                        </a>
                    </div>
                    <div class="text-lineup">
                        Or Sign Up Using</div>
                    <a href="" class="signup">
                        Sign Up</a>
-->
                </form>
            </div>
        </div>
    </div>
</body>
</html>    
<% } // else of line 14 closed.  %>