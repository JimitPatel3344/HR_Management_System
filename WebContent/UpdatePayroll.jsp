<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.UpdatePayrollDao" %>
<%@ page import = "java.lang.*" %>
<%@ page import = "model.Payroll" %>   

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
    <link rel="stylesheet" href="css/salary_style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<!--	<link rel="stylesheet" href="https://zavoloklom.github.io/material-design-iconic-font/icons.html">-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css">
    <title> Update Employee Salary </title>	
</head>
<body background="BACK.jpg">
    <div class="head">
        <div class="main-head">
            <div class="form-sec">
<% Payroll pay = UpdatePayrollDao.getData(Long.parseLong(request.getParameter("id"))); %>

                <form action = "PayrollUpdate" method = "post" name = "Updatesalary">
                    <span class="label-log">SALARY</span>
				 <div class="user">
                        <input type="hidden" name="payrollid" value="<%=pay.getPayrollid()%>" >
                   </div>			
                    <div class="user">
                        <input type="number" name="eid" placeholder="Enter Employee ID" value="<%=pay.getEid() %>" required>
                    </div>
					<div class="user">
                        <select name="payrolltype" class="blood" required>
                        <option value=" <%= pay.getPayrolltype() %> "> <%= pay.getPayrolltype() %></option>
                           <option value="Net Banking">Net Banking</option>
                            <option value="Cheque">Cheque</option>
                            <option value="Cash">Cash</option>
                            </select>
                    </div>                            
                    <div class="user">
                        <select name="payrollmonth" class="blood" required>
                           <option value="<%= pay.getPayrollmonth() %>"> <%= pay.getPayrollmonth() %></option>
                            <option value="january">JANUARY</option>
                            <option value="february">FEBRUARY</option>
                            <option value="march">MARCH</option>
                            <option value="april">APRIL</option>
                            <option value="may">MAY</option>
                            <option value="june">JUNE</option>
                            <option value="july">JULY</option>
                            <option value="august">AUGUST</option>
                            <option value="september">SEPTEMBER</option>
                            <option value="october">OCTOBER</option>
                            <option value="november">NOVEMBER</option>
                            <option value="december">DECEMBER</option> 
                        </select>
                    </div>                    
                    <div class="user">
                       <input type="text" name="payrolldate" placeholder="Enter date on which salary is payed" onfocus="(this.type='date')" onblur="(this.type='date')" value="<%= pay.getPayrolldate() %>" required>
                    </div>                    
                     <div class="user">
                        <input type="number" name="amount" placeholder="Enter Salary" value="<%=pay.getAmount() %>" required>
                    </div>					
                    <div class="forgot">
                        <input type="reset" class="cancelbtn">
                    </div>                    
                    <div class="button-cont">
                        <button class="log">
                            Update Payroll </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
<% } // else of line 14 closed.  %>