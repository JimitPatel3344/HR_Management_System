
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDao;
import model.Login;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//	out.println(request.getParameter("Ulogid"));
		try 
		{ 
			Login logininfo = new Login();
			logininfo.setLogid(Integer.parseInt(request.getParameter("logid")));
			logininfo.setEid(Integer.parseInt(request.getParameter("eid")));
			logininfo.setPassword(request.getParameter("password"));
			logininfo.setRid(Integer.parseInt(request.getParameter("rid")));
		//	Class.forName("com.mysql.jdbc.Driver");
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diplomaproject","root","");
		//	Statement st = JdbcConn.getConnection();
		// String sql = "insert into login values(?,?,?,?);";
		//	String sql = "SELECT * FROM `Login` WHERE `logid` = '"+logininfo.getLogid()+"' and `password`= '"+logininfo.getPassword()+"';";
		//	String sql = "SELECT * FROM 'Login' WHERE 'logid' = '"+logininfo.getLogid()+"' and 'password'= '"+logininfo.getPassword()+"'";
		/*	String sql = "SELECT * FROM `Login` WHERE `logid` = '"+logininfo.getLogid()+"' and `password`= '"+logininfo.getPassword()+"';";
			PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		*/
		/*	ps.setInt(1,logininfo.getLogid());
			ps.setInt(2,logininfo.getEid());
			ps.setString(3,logininfo.getPassword());
			ps.setInt(4,logininfo.getRid());
		*/	
		/*	ResultSet result = ps.executeQuery();
			boolean flag = false;
			while(result.next()) {
				flag=true;
				break; 
			} 
		*/	
			if(LoginDao.verifyLogin(logininfo))
			{
				HttpSession session = request.getSession();
				session.setAttribute("eid", Integer.parseInt(request.getParameter("eid")) );
				if(logininfo.getRid()==1)
				{
					response.sendRedirect("CeoDashboard.jsp");
				}
				else if(logininfo.getRid()==2)
				{
					response.sendRedirect("HrManagerDashboard.jsp");
				}
				else if(logininfo.getRid()==3)
				{
					response.sendRedirect("ProjectManagerDashboard.jsp");
				}
				else if(logininfo.getRid()==4)
				{
					response.sendRedirect("EmployeeDashboard.jsp");
				}
				else
				{
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized try to access page.");
				}
				//out.print("Login Success.");
				//out.print("<script> alert('Login successful!!!'); </script>");
				//response.sendRedirect("Login.jsp");
			}
			else
			{
				//out.print("<script> prompt('Invalid ID or Password'); </script>");
				//out.print("Invalid ID or Password");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");  
		        rd.include(request, response);  
		        //out.print("Invalid ID or Password");
		        out.print("<script> alert('Invalid ID or Password'); </script>");
			//	String msg = "Invalid login Id or password.";
			//	response.sendError(1, msg);
			//	int sc = 400;
			//	response.sendError(sc, msg);
			//	out.print("Login Fail.");
			//	response.sendError(0, "Invalid login Id or password.");
			//	{	out.print("<script> prompt('Login unsuccessful!!!'); </script>"); }
			//	{ 	response.sendRedirect("Login.jsp"); }
			}
			// ps.close(); // con.close();			
			
			/*
			out.println(request.getParameter("Ulogid"));
			Login logininfo = new Login();
			int logid = Integer.parseInt(request.getParameter("Ulogid"));
			logininfo.setLogid(logid);
			int eid = Integer.parseInt(request.getParameter("Ueid"));
			logininfo.setEid(eid);
			String password = request.getParameter("Upassword");
			logininfo.setPassword(password);
			int rid = Integer.parseInt(request.getParameter("Urid"));
			logininfo.setRid(rid);
	
		/*	logininfo.setLogid(123);
			logininfo.setEid(123);
			logininfo.setPassword(request.getParameter("Upassword"));
			logininfo.setRid(123); 
		*/
		//	out.print(request.getParameter("Ulogin"));
		/*	out.print(logininfo.getLogid());
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/diplomaproject","root","");
		//	Statement st = c.createStatement();
		/*	Integer Log = logininfo.getLogid();
			Integer E = logininfo.getEid();
			String Pass = logininfo.getPassword();
			Integer R = logininfo.getRid();
		*/
			//String sql = "insert into 'login' values("+logininfo.getLogid()+","+logininfo.getEid()+",'"+logininfo.getPassword()+"',"+logininfo.getRid()+")";
			
		/*	String sql = "INSERT INTO `login` (`logid`, `eid`, `password`, `rid`) VALUES (?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1,logininfo.getLogid());
			ps.setInt(2,logininfo.getEid());
			ps.setString(3,logininfo.getPassword());
			ps.setInt(4,logininfo.getRid());
			
			
			int result = ps.executeUpdate();
			if(result==1) {
			out.print("Records inserted sussefully!!! ");
			} 
			ps.close(); c.close();
			*/		
		}
		catch (Exception e ) { out.print(e); }  //e.printStackTrace()
	}

}


/*
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet implementation class LoginCheck
 
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     // @see HttpServlet#HttpServlet()
     
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

} */
