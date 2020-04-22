package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcConn;

public class DeletePayrollDao {

	public DeletePayrollDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deletePayroll(Long id) throws SQLException, ClassNotFoundException
	{
		boolean flag = false; 
		try 
		{
			String sql = "DELETE FROM `payroll` WHERE `payrollid` = ? ; ";  
			PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  ``
			ps.setLong(1,id);
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
