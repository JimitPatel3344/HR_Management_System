package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Task;
import util.JdbcConn;

public class UpdateTaskDao {

	public UpdateTaskDao() {
		// TODO Auto-generated constructor stub
	}

	public static Task updateTask(int id) throws SQLException, ClassNotFoundException
	{
		Task tas = new Task();
		String sql = "SELECT * FROM `task` WHERE `tid` = ? ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setInt(1,id);
		ResultSet result = ps.executeQuery();  
		while(result.next()) 
		{  
			tas.setTid(result.getInt("tid"));
			tas.setDestinationeid(result.getInt("destination_eid"));
			tas.setPid(result.getInt("pid"));
			tas.setDestinationEname(result.getString("destinationEname"));
			tas.setPname(result.getString("pname"));
			tas.setTsdate(result.getString("tsdate"));
			tas.setTedate(result.getString("tedate"));
			tas.setTpriority(result.getString("tpriority"));
			tas.setTdes(result.getString("tdes"));
			tas.setTstatus(result.getInt("tstatus"));			
		} 
		ps.close();	
		return tas;		
	}
	
	public static boolean updateTask(Task tas) throws ClassNotFoundException, SQLException
	{
		boolean flag = false;
		String sql = "UPDATE `task` SET `destinationEname` = ? , `pname` = ? , `tsdate` = ? , `tedate` = ? , `tpriority` = ? , `tdes` = ? WHERE `tid` = ? ; ";
	//	String sql = "UPDATE `task` SET `ename`=[value-3],`pname`=[value-5],`tsdate`=[value-6],`tedate`=[value-7],`tpriority`=[value-8],`tdes`=[value-9],`tstatus`=[value-10] WHERE 1 ;";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql);
		ps.setString(1,tas.getDestinationEname());
		ps.setString(2,tas.getPname());
		ps.setString(3,tas.getTsdate());
		ps.setString(4,tas.getTedate());
		ps.setString(5,tas.getTpriority());
		ps.setString(6,tas.getTdes());
		ps.setInt(7,tas.getTid());
		int numberOfAffectedRows = ps.executeUpdate();
		if(numberOfAffectedRows == 1)
		{
			flag = true;
		}
		ps.close();  return flag;
	}
	
	public static boolean updateToDoTask(Task tas) throws SQLException, ClassNotFoundException
	{
		boolean flag = false;
		String sql = "UPDATE `task` SET `tstatus` = ? WHERE `tid` = ? ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql);
		ps.setInt(1,tas.getTstatus());
		ps.setInt(2,tas.getTid());
		int numberOfAffectedRows = ps.executeUpdate();
		if(numberOfAffectedRows == 1)
		{
			flag = true;
		}
		ps.close();  return flag;
	}
	
}
