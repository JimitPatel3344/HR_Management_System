package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcConn;

public class AddProjectManagerDao {

	public AddProjectManagerDao() {
		// TODO Auto-generated constructor stub
	}

	public static boolean addProjectManager(int pmid, int eid) throws SQLException, ClassNotFoundException
	{
		boolean flag = false;
		String sql = " UPDATE `employee` SET `pmid` = ? WHERE `eid` = ? ; " ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
	//	ps.setInt(1,logininfo.getLogid());
		ps.setInt(1,pmid);
		ps.setInt(2,eid);
		int result = ps.executeUpdate();  
		if(result == 1)
		{	
			flag = true;
		}		
		ps.close(); 
		return flag;
	}
}
