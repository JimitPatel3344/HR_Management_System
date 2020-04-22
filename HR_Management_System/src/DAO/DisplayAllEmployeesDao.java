package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import model.Register;
import util.JdbcConn;

public class DisplayAllEmployeesDao 
{

	public static List<Register> displayAllEmployees() throws SQLException, ClassNotFoundException
	{
//		String sql = "SELECT eid, logid, rid, ename, eadd, emno, eemail, password, edob, city, state, bloodgroup FROM `employee` ; ";
		String sql = "SELECT * FROM `employee` ORDER BY eid ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ResultSet result = ps.executeQuery();  
		List<Register> eList = new ArrayList<Register>();
		while(result.next()) 
		{  
			Register re = new Register();
			re.setEid(result.getInt("eid"));
			re.setLogid(result.getInt("logid"));
			re.setRid(result.getInt("rid"));
			re.setEname(result.getString("ename"));
			re.setEmno(result.getString("emno"));
			re.setEemail(result.getString("eemail"));
			re.setEadd(result.getString("eadd"));
			re.setBloodgroup(result.getString("bloodgroup"));
			re.setCity(result.getString("city"));
			re.setEdob(result.getString("edob"));
			re.setPassword(result.getString("password"));
			re.setState(result.getString("state"));
			eList.add(re);
		} 
		ps.close(); 
		return eList;		
	}
	
	public static int countEmployee() throws ClassNotFoundException, SQLException
	{
		int count=0;
		String sql = " SELECT COUNT(*) FROM `employee` ; "  ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();  
		while(result.next())
		{
			count = result.getInt(1);
		}
		
		return count;
	}
}
