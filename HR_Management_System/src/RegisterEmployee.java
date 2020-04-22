

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.RegisterDao;
import model.Register;

/**
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/RegisterEmployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployee() {
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
			reg.setLogid(Integer.parseInt(request.getParameter("logid")));
			reg.setRid(Integer.parseInt(request.getParameter("rid")));
			reg.setEmno(request.getParameter("emno"));
			reg.setBloodgroup(request.getParameter("bloodgroup"));
			reg.setCity(request.getParameter("city"));
			reg.setEadd(request.getParameter("eadd"));
			reg.setEdob(request.getParameter("edob"));
			reg.setEemail(request.getParameter("eemail"));
			reg.setEgender(request.getParameter("egender"));
			reg.setEname(request.getParameter("ename"));
			reg.setPassword(request.getParameter("password"));
			reg.setState(request.getParameter("state"));
			
			if(RegisterDao.register(reg)==true) 
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
