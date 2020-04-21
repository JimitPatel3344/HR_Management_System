package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.JdbcConn;

public class DeletEmployeeDao {
	
	public static boolean deleteEmployee(Integer id) throws SQLException, ClassNotFoundException
	{
		boolean flag = false; 
		try 
		{
			String sql = "DELETE FROM `employee` WHERE `eid` = ? ; ";  
			PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  ``
			ps.setInt(1,id);
			int effectedRows = ps.executeUpdate();    
			ps.close(); 
			if(effectedRows>0) 
			{
				String sqlLogin = "DELETE FROM `login` WHERE `eid` = ? ; ";  
				PreparedStatement ps2 = (PreparedStatement) JdbcConn.getConnection(sqlLogin); // con.prepareStatement(sql);  ``
				ps2.setInt(1,id);
				int effectedRows2 = ps2.executeUpdate();    
				ps2.close(); 
				if(effectedRows2>0) 
				{
					flag = true;
				}
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
