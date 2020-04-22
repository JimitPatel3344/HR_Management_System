

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UpdatePayrollDao;
import model.Payroll;

/**
 * Servlet implementation class UpdatePayrollController
 */
@WebServlet("/UpdatePayrollController")
public class UpdatePayrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try 
		{ 
			Payroll pay = new Payroll();			
			pay.setPayrollid(Long.parseLong(request.getParameter("payrollid")));
			pay.setEid(Integer.parseInt(request.getParameter("eid")));
			pay.setPayrolltype(request.getParameter("payrolltype"));
			pay.setPayrollmonth(request.getParameter("payrollmonth"));
			pay.setPayrolldate(request.getParameter("payrolldate"));
			pay.setAmount(Integer.parseInt(request.getParameter("amount")));
								
			if(UpdatePayrollDao.updatePayroll(pay)==true) 
			{
				out.print("Salary payed successful!!!");
				response.sendRedirect("ViewPayrollDetails.jsp");
				out.print("<script> alert('Salary payed successful!!!'); </script>");
			}
			else
			{
				out.print("Salary payed unsuccessful!!!");
				response.sendRedirect("ViewPayrollDetails.jsp");
				out.print("<script> alert('Salary payed unsuccessful!!!'); </script>");
			}		
			
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()

		
	}

}
