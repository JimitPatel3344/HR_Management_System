

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeletePayrollDao;

/**
 * Servlet implementation class DeletePayrollController
 */
@WebServlet("/DeletePayrollController")
public class DeletePayrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePayrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//	out.println(request.getParameter("Ulogid"));
		try 
		{
			if(DeletePayrollDao.deletePayroll(Long.parseLong(request.getParameter("id"))) == true)   
			{  
				out.print("<script> alert('Payroll Delete operation successful!!!'); </script>");  
				response.sendRedirect("ViewPayrollDetails.jsp");  
			}  
			else  
			{  
				out.print("<script> alert('Payroll Delete operation unsuccessful!!!'); </script>");  
				response.sendRedirect("ViewPayrollDetails.jsp");  
			}   	
		} 
		catch (Exception e )  
		{ 
			out.print(e);  
			e.printStackTrace();  //e.printStackTrace() 
		}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
