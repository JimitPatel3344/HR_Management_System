package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Project;

import util.JdbcConn;

public class UpdateProjectDao {

	public UpdateProjectDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static Project getData(int id) throws SQLException, ClassNotFoundException
	{
		Project prj = new Project();
		String sql = "SELECT * FROM `project` WHERE `pid` = ? ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setInt(1,id);		
		ResultSet result = ps.executeQuery();  		
		while(result.next()) 
		{  
			prj.setPid(result.getInt("pid"));
			prj.setPmid(result.getInt("pmid"));
			prj.setPname(result.getString("pname"));
			prj.setClientname(result.getString("clientname"));
			prj.setProgramminglanguage(result.getString("programminglanguage"));
			prj.setDatabasetechnology(result.getString("databasetechnology"));
			prj.setPcost(result.getDouble("pcost"));
			prj.setPsdate(result.getString("psdate"));
			prj.setPsdate(result.getString("pedate"));
			prj.setPdes(result.getString("pdes"));
			
		} 
		ps.close();	
		return prj;		
	}

	public static boolean updateProject(Project prj) throws SQLException, ClassNotFoundException
	{
		//String sql = "UPDATE `project` SET `eid` = '"+prj.getEid()+"', `logid` = '"+prj.getLogid()+"', `rid` = '"+prj.getRid()+"', `ename` = '"+prj.getEname()+"', `eadd` = '"+prj.getEadd()+"', `emno` = '"+prj.getEmno()+"', `eemail`  = '"+prj.getEemail()+"', `password`  = '"+prj.getPassword()+"', `edob` = '"+prj.getEdob()+"', `egender` = '"+prj.getEgender()+"', `city`  = '"+prj.getCity()+"', `state` = '"+prj.getState()+"', `bloodgroup` = '"+prj.getBloodgroup()+"' WHERE `eid`  = '"+prj.getEid()+"' ;";
		String sql = " UPDATE `project` SET `pid` = ? , `pmid` = ? , `pname` = ? , `clientname` = ? , `programminglanguage` = ? , `databasetechnology` = ? , `pcost` = ? , `psdate` = ? , `pedate` = ? , `pdes` = ? WHERE `pid` = ? " ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  				
		ps.setInt(1,prj.getPid());
		ps.setInt(2,prj.getPmid());
		ps.setString(3,prj.getPname());
		ps.setString(4,prj.getClientname());
		ps.setString(5,prj.getProgramminglanguage());
		ps.setString(6,prj.getDatabasetechnology());
		ps.setDouble(7,prj.getPcost());
		ps.setString(8,prj.getPsdate());
		ps.setString(9,prj.getPedate());
		ps.setString(10,prj.getPdes());
		ps.setInt(11,prj.getPid());
		int result = ps.executeUpdate();  
		boolean flag = false;  
		if(result == 1)
		{			
				flag = true;			
		}		
		ps.close();  return flag;
		
	}
}
