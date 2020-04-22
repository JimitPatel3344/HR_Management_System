

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AssignTaskDao;
import model.Task;

/**
 * Servlet implementation class AssignTaskController
 */
@WebServlet("/AssignTaskController")
public class AssignTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTaskController() {
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
		// doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try 
		{ 
			Task tas = new Task();
			
		//  tas.setTid(Integer.parseInt(request.getParameter("tid")));
		//  tas.setEid(Integer.parseInt(request.getParameter("eid")));
			tas.setSourceeid((int)session.getAttribute("eid"));
			tas.setDestinationEname(request.getParameter("destinationEname"));
		//  tas.setPid(Integer.parseInt(request.getParameter("pid")));
			tas.setPname(request.getParameter("pname"));
			tas.setTsdate(request.getParameter("tsdate"));
			tas.setTedate(request.getParameter("tedate"));
			tas.setTpriority(request.getParameter("tpriority"));
			tas.setTdes(request.getParameter("tdes"));
		//  tas.setTstatus(request.getParameter("tstatus"));
						 
			if(AssignTaskDao.addTask(tas)==true) 
			{
				out.print("Task assigned successful!!!");
				//response.sendRedirect("Registration.jsp");
				out.print("<script> alert('Task assigned successful!!!'); </script>");
			}
			else
			{
				out.print("Task assigned unsuccessful!!!");
				out.print("<script> alert('Task assigned unsuccessful!!!'); </script>");
			}		
			
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()

		
	}

}
