

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UpdateTaskDao;
import model.Task;

/**
 * Servlet implementation class UpdateTaskController
 */
@WebServlet("/UpdateTaskController")
public class UpdateTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskController() {
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
		//doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try 
		{ 
			Task tas = new Task();
			tas.setTid(Integer.parseInt(request.getParameter("tid")));
			tas.setPname(request.getParameter("pname"));
			tas.setDestinationEname(request.getParameter("destinationEname"));			
			tas.setTpriority(request.getParameter("tpriority"));
			tas.setTsdate(request.getParameter("tsdate"));
			tas.setTedate(request.getParameter("tedate"));
			tas.setTdes(request.getParameter("tdes"));
			
			if(UpdateTaskDao.updateTask(tas)==true) 
			{
				//out.print("Project updated successfully!!!");
				response.sendRedirect("ViewAssignedTasks.jsp");
				//out.print("<script> alert('Project updated successfully!!!'); </script>");
			}
			else
			{
				response.sendRedirect("ViewAssignedTasks.jsp");
				//out.print("Project updated unsuccessfully!!!");

				//out.print("<script> alert('Project updated unsuccessfully!!!'); </script>");
			}		
			
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()
				
		
	}

}
