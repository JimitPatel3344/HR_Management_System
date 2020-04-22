

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DeleteTaskDao;

/**
 * Servlet implementation class DeleteTaskController
 */
@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaskController() {
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
			if(DeleteTaskDao.deleteTask(Integer.parseInt(request.getParameter("id"))) == true)   
			{  
				out.print("<script> alert('Task Delete operation successful!!!'); </script>");  
				response.sendRedirect("ViewTask.jsp");  
			}  
			else  
			{  
				out.print("<script> alert('Task Delete operation unsuccessful!!!'); </script>");  
				response.sendRedirect("ViewTask.jsp");  
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
