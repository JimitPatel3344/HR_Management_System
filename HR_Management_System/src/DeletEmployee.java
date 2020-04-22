

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeletEmployeeDao;


/**
 * Servlet implementation class DeletEmployee
 */
@WebServlet("/DeletEmployee")
public class DeletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//	out.println(request.getParameter("Ulogid"));
		try 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			out.print("id = "+id);
			if(DeletEmployeeDao.deleteEmployee(Integer.parseInt(request.getParameter("id"))) == true)   
			{  
				//out.print("<script> alert('Employee registered successful!!!'); </script>");  
				response.sendRedirect("ViewEmployees.jsp");  
			}  
			else  
			{  
				//out.print("<script> alert('Employee Delet operation unsuccessful!!!'); </script>");  
				response.sendRedirect("ViewEmployees.jsp");  
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
