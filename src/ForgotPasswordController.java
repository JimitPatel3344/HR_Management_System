

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ForgotPasswordDao;
import model.Register;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ForgotPasswordController" })
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
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
	//	out.println(request.getParameter("Ulogid"));
		try 
		{ 
			Register reg = new Register();
			reg.setEid(Integer.parseInt(request.getParameter("eid")));
			reg.setEemail(request.getParameter("eemail"));
			reg.setEname(request.getParameter("ename"));
			reg.setPassword(request.getParameter("password"));
			if(ForgotPasswordDao.changePassword(reg) == true) 
			{
				out.print("<script> alert('Password Updated successful!!!'); </script>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				//response.sendRedirect("Registration.jsp");
				
			}
			else
			{
				out.print("Password Updated unsuccessful!!!");
			}
		}
		
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()
		
	}

}
