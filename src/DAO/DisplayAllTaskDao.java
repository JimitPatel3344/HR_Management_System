package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.JdbcConn;
public class DisplayAllTaskDao {
	public DisplayAllTaskDao() {
		// TODO Auto-generated constructor stub
	}	
	public static List<Task> displayAllToDoTask(int eid) throws SQLException, ClassNotFoundException
	{		
//		String sql = "SELECT eid, logid, rid, ename, eadd, emno, eemail, password, edob, city, state, bloodgroup FROM `employee` ; ";
		String sql = "SELECT * FROM `task` WHERE `destination_eid` = ? ORDER BY tid ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setInt(1,eid);
		ResultSet result = ps.executeQuery(); 		
		/*
		 * String sqle = " SELECT ename FROM `employee` WHERE `eid` = '"+result.getInt(
		 * "destination_eid")+"' ; " ; PreparedStatement pse = (PreparedStatement)
		 * JdbcConn.getConnection(sqle); // con.prepareStatement(sql); ResultSet resulte
		 * = pse.executeQuery();
		 */		
		List<Task> tList = new ArrayList<Task>();
		while(result.next()) 
		{  
			Task re = new Task();
			re.setTid(result.getInt("tid"));
			re.setDestinationeid(result.getInt("destination_eid"));
			re.setSourceeid(result.getInt("source_eid"));
			re.setPid(result.getInt("pid"));
			re.setDestinationEname(result.getString("destinationEname"));
			re.setPname(result.getString("pname"));
			re.setTsdate(result.getString("tsdate"));
			re.setTedate(result.getString("tedate"));
			re.setTpriority(result.getString("tpriority"));
			re.setTdes(result.getString("tdes"));
			re.setTstatus(result.getInt("tstatus"));
			tList.add(re);
		} 
		ps.close(); 
		return tList;		
	}		
	public static int countTask(int eid) throws ClassNotFoundException, SQLException
	{
		int count=0;
		String sql = " SELECT COUNT(*) FROM `task` WHERE `destination_eid` = ? ; "  ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		ps.setInt(1,eid);
		ResultSet result = ps.executeQuery();  
		while(result.next())
		{
			count = result.getInt(1);
		}		
		return count;
	}	
	public static List<Task> displayAllAssignedTask(int eid) throws SQLException, ClassNotFoundException
	{		
//		String sql = "SELECT eid, logid, rid, ename, eadd, emno, eemail, password, edob, city, state, bloodgroup FROM `employee` ; ";
		String sql = "SELECT * FROM `task` WHERE `source_eid` = ? ORDER BY tid ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setInt(1,eid);
		ResultSet result = ps.executeQuery();  		
		/*
		 * String sqle = " SELECT ename FROM `employee` WHERE `eid` = '"+result.getInt(
		 * "destination_eid")+"' ; " ; PreparedStatement pse = (PreparedStatement)
		 * JdbcConn.getConnection(sqle); // con.prepareStatement(sql); ResultSet resulte
		 * = pse.executeQuery();
		 */		
		List<Task> tList = new ArrayList<Task>();
		while(result.next()) 
		{  
			Task re = new Task();
			re.setTid(result.getInt("tid"));
			re.setDestinationeid(result.getInt("destination_eid"));
			re.setSourceeid(result.getInt("source_eid"));
			re.setPid(result.getInt("pid"));
			re.setDestinationEname(result.getString("destinationEname"));
			re.setPname(result.getString("pname"));
			re.setTsdate(result.getString("tsdate"));
			re.setTedate(result.getString("tedate"));
			re.setTpriority(result.getString("tpriority"));
			re.setTdes(result.getString("tdes"));
			re.setTstatus(result.getInt("tstatus"));
			tList.add(re);
		} 
		ps.close(); 
		return tList;		
	}
}
