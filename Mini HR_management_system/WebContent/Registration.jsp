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
	<meta charset="ISO-8859-1">
 	<meta charset="UTF-8">
    <title>Employee Registration </title>
    <link rel="stylesheet" href="css/registration_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
    <!--        <link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
        <title> Register Employee </title>	
</head>
<body background="BACK.jpg">
	 <div class="head">
        <div class="main-head">
            <div class="form-sec">


                <form action="RegisterEmployee" method = "post" name = "registration">
                    <span class="label-log">EMPLOYEE REGISTRATION</span>

                    <div class="user">

                        <input type="number" name="eid" placeholder="Enter Employee ID" required>
                    </div>

                    <div class="user">

                        <input type="number" name="logid" placeholder="Enter Login ID" required>
                    </div>

                    <div class="user">

                        <input type="number" name="rid" placeholder="Enter Role ID" required>
                    </div>

                    <div class="user">
                        <input type="text" name="ename" placeholder="Enter Name" required>
                    </div>

                    <div class="user">
                        <textarea name="eadd" rows="4" cols="25" class="add" placeholder="Enter Address" required>
                        </textarea>
                    </div>

                    <div class="user">
                    
                        <input type="text" name="emno" placeholder="Enter Mobile NO." maxlength="10" required>
                    </div>
                    <div class="user">
                        <input type="email" name="eemail" placeholder="Enter Email Address" required>
                    </div>
                    <div class="user">
                        <input type="password" name="password" placeholder="Type Your Password" required>
                    </div>

                    <div class="user">
                        <input type="date" name="edob" placeholder="Enter Date Of Birth" required>
                    </div>

                    <div class="user">
                        <input type="radio" name="egender" required> <span class="text">Male</span>
                        <input type="radio" name="egender"> <span class="text_1">Female</span>
                    </div>

                    <div class="user">
                        <input type="text" name="city" placeholder="Enter City" required>
                    </div>

                    <div class="user">
                        <input type="text" name="state" placeholder="Enter State" required>
                    </div>

                    <div class="user">
                        <select name="bloodgroup" class="blood" required>
                           <option value="">Enter BloodGroup</option>
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
                            Register </button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</body>
</html>
<% } // else of line 14 closed.  %>