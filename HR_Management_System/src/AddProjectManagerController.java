

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AddProjectManagerDao;


/**
 * Servlet implementation class AddProjectManagerController
 */
@WebServlet("/AddProjectManager")
public class AddProjectManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProjectManagerController() {
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
		try 
		{ 
			int Pmid = (Integer.parseInt(request.getParameter("pmid")));
			int Eid = (Integer.parseInt(request.getParameter("eid")));
			if(AddProjectManagerDao.addProjectManager(Pmid,Eid)==true) 
			{
				out.print("Employee registered successful!!!");
				//response.sendRedirect("Registration.jsp");
				out.print("<script> alert('Employee registered successful!!!'); </script>");
			}
			else
			{
				out.print("Employee registered unsuccessful!!!");
			}		
			
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()

	}

}
