 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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


                <form action="Login" method="post" name="login" onSubmit="return valid();">
                    <span class="label-log">Login to <img src="images/logo.png">Consult</span>
                    
                    <div class="user">
                        <span class="user-data">Login ID</span>
                        <input type="number" name="logid" placeholder="Enter your login Id" title="Login ID can not be left blank." required />
                      
                        <span class="zmdi zmdi-account-o user-icon"></span>
                    </div>
                    
                    <div class="user">
                        <span class="user-data">Employee ID</span>

                        <input type="number" name="eid" placeholder="Type Your Employee ID" title="Employee ID can not be left blank." required />
                        <span class="zmdi zmdi-account-o user-icon"></span>
                    </div>
                    
                      <div class="user">
                        <span class="user-data">Password</span>
                        <input type="password" name="password" placeholder="Type Your Password" title="Password can not be left blank." required />
                        <span class="zmdi zmdi-lock-outline user-icon"></span>
                    </div>
                    
                    <div class="user">
                        <span class="user-data">Role ID</span>

                        <input type="number" name="rid" placeholder="Type Your Role ID" title="Role ID can not be left blank." required />
                        <span class="zmdi zmdi-account-o user-icon"></span>
                    </div>
                    
                  	<div class="forgot">
                       <input type="reset" class="cancelbtn">
                        <a href="ForgotPassword.jsp" class="for">
                            Forgot password?</a>
    
                    </div>
                    <div class="button-cont">
                        <button class="log">
                            Login</button> 
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
    
<!-- <script type="text/javascript">
/*
 function valid()
{
	
	var logid=document.login.Ulogid.value;
	var eid = document.login.Ueid.value;
	var pass = document.login.Upassword.value;
	var rid = document.login.Urid.value;
	var flag = true;
	alert(logid+"#"+eid+"#"+pass+"#"+rid+"#");
	
	if (logid == "")
	{
		alert("Login ID can not be left blank..!!!");
		document.login.Ulogid.focus();
		return false;	
	}	
	else if (pass == NULL )
	{
		if(flag == true)
		{ 
			alert(logid+"*"+eid+"*"+pass+"*"+rid+"*");
			alert("Password can not be left blank..!!!");
			document.login.Upassword.focus();
			flag = false; 	return flag;	
		}
		else { return flag; }
	
	}
	var rid = document.login.Urid.value;
	else if (rid == "" || rid == NULL )
	{
		if(flag == true)
		{ 
			alert("Role ID can not be left blank..!!!");
			document.login.Urid.focus();
			flag = false; 
		}
		else { return flag; }
	//	return false;	
	}
	else if (eid == "" || eid == NULL )
	{
		if(flag == true)
		{ 
			alert("Employee ID can not be left blank..!!!");
			document.login.Ueid.focus();
			flag = false; 
		}
		else { return flag; }
	}  else{}	
	return flag;		
} */
</script>
    
 -->    
