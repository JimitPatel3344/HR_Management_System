package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Project;
import util.JdbcConn;

public class AddProjectDao {

	public AddProjectDao() {
		// TODO Auto-generated constructor stub
	}
	public static boolean addProject(Project prj) throws SQLException, ClassNotFoundException
	{
		String sql = " INSERT INTO `project`(`pmid`, `pname`, `clientname`, `programminglanguage`, `databasetechnology`, `pcost`, `psdate`, `pedate`, `pdes`) VALUES (?,?,?,?,?,?,?,?,?) " ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
	//	ps.setInt(1,logininfo.getLogid());
	//	ps.setInt(1,prj.getPid());
		ps.setInt(1,prj.getPmid());
		ps.setString(2,prj.getPname());
		ps.setString(3,prj.getClientname());
		ps.setString(4,prj.getProgramminglanguage());
		ps.setString(5,prj.getDatabasetechnology());
		ps.setDouble(6,prj.getPcost());
		ps.setString(7,prj.getPsdate());
		ps.setString(8,prj.getPedate());
		ps.setString(9,prj.getPdes());
				
		int result1 = ps.executeUpdate();  
		boolean flag = false;  
		if(result1 == 1)
		{	
			flag = true;
		}
		
		ps.close(); 
		return flag;		
	
	}	
}
