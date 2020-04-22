package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcConn;

public class DeleteProjectDao {

	public DeleteProjectDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deleteProject(Integer id) throws SQLException, ClassNotFoundException
	{
		boolean flag = false; 
		try 
		{
			String sql = "DELETE FROM `project` WHERE `pid` = ? ; ";  
			PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  ``
			ps.setInt(1,id);
			int effectedRows = ps.executeUpdate();    
			ps.close(); 
			if(effectedRows>0) 
			{
				flag = true;
			}
				
		}
		catch (Exception e )  
		{ 
			// out.print(e);  
			e.printStackTrace();  //e.printStackTrace() 
		}
		return flag;	
	}

}
