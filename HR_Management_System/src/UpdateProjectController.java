
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UpdateProjectDao;
import model.Project;

/**
 * Servlet implementation class UpdateProjectController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UpdateProjectController" })
public class UpdateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectController() {
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
			Project prj = new Project();
			prj.setPid(Integer.parseInt(request.getParameter("pid")));
			prj.setPmid(Integer.parseInt(request.getParameter("pmid")));
			prj.setPname(request.getParameter("pname"));
			prj.setClientname(request.getParameter("clientname"));
			prj.setProgramminglanguage(request.getParameter("programminglanguage"));
			prj.setDatabasetechnology(request.getParameter("databasetechnology"));
			prj.setPcost(Double.parseDouble(request.getParameter("pcost")));
			prj.setPsdate(request.getParameter("psdate"));
			prj.setPedate(request.getParameter("pedate"));
			prj.setPdes(request.getParameter("pdes"));
			
			if(UpdateProjectDao.updateProject(prj)==true) 
			{
				//out.print("Project updated successfully!!!");
				response.sendRedirect("ViewProjects.jsp");
				//out.print("<script> alert('Project updated successfully!!!'); </script>");
			}
			else
			{
				response.sendRedirect("ViewProjects.jsp");
				//out.print("Project updated unsuccessfully!!!");

				//out.print("<script> alert('Project updated unsuccessfully!!!'); </script>");
			}		
			
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()
		
	}

}
