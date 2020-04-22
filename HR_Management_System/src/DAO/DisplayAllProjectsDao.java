package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.JdbcConn;

public class DisplayAllProjectsDao {

	public DisplayAllProjectsDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Project> displayAllProjects() throws SQLException, ClassNotFoundException
	{
//String sql = "SELECT eid, logid, rid, ename, eadd, emno, eemail, password, edob, city, state, bloodgroup FROM `employee` ; ";
		String sql = "SELECT * FROM `project` ORDER BY pid ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ResultSet result = ps.executeQuery();  
		List<Project> pList = new ArrayList<Project>();
		while(result.next()) 
		{  
			Project re = new Project();
			re.setPid(result.getInt("pid"));
			re.setPmid(result.getInt("pmid"));
			re.setPname(result.getString("pname"));
			re.setClientname(result.getString("clientname"));
			re.setProgramminglanguage(result.getString("programminglanguage"));
			re.setDatabasetechnology(result.getString("databasetechnology"));
			re.setPcost(result.getDouble("pcost"));
			re.setPsdate(result.getString("psdate"));
			re.setPedate(result.getString("pedate"));
			re.setPdes(result.getString("pdes"));
			pList.add(re);
		} 
		ps.close(); 
		return pList;		
	}

	public static int countProject() throws ClassNotFoundException, SQLException
	{
		int count=0;
		String sql = " SELECT COUNT(*) FROM `project` ; "  ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();  
		while(result.next())
		{
			count = result.getInt(1);
		}
		
		return count;
	}
}
