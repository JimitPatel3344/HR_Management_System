package DAO;
import model.Login;
import util.JdbcConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {

	public LoginDao() {
		// TODO Auto-generated constructor stub
	}
	public static boolean verifyLogin(Login logininfo) throws SQLException, ClassNotFoundException
	{
		String sql = "SELECT * FROM `Login` WHERE `logid` = '"+logininfo.getLogid()+"' and `password` = '"+logininfo.getPassword()+"' and `eid` = '"+logininfo.getEid()+"' and `rid` = '"+logininfo.getRid()+"' ;";  
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  ``
		ResultSet result = ps.executeQuery();  
		boolean flag = false;  
		while(result.next()) {  
			flag=true;  
			break;   
		} 
		ps.close(); 
		if(flag==true) 
		{
			return true;
		}
		else
		{
			return flag;
		}
	}

}
