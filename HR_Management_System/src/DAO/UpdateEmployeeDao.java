package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Register;
import util.JdbcConn;

public class UpdateEmployeeDao 
{
	
	public static Register getData(int id) throws SQLException, ClassNotFoundException
	{
		Register reg = new Register();
		String sql = "SELECT * FROM `employee` WHERE `eid` = ? ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setInt(1,id);
		ResultSet result = ps.executeQuery();  
		while(result.next()) 
		{  
			reg.setEid(result.getInt("eid"));
			reg.setLogid(result.getInt("logid"));
			reg.setRid(result.getInt("rid"));
			reg.setEname(result.getString("Ename"));
			reg.setEadd(result.getString("eadd"));
			reg.setEmno(result.getString("emno"));
			reg.setEemail(result.getString("eemail"));
			reg.setPassword(result.getString("password"));
			reg.setEdob(result.getString("edob"));
			reg.setEgender(result.getString("egender"));
			reg.setCity(result.getString("city"));
			reg.setState(result.getString("state"));
			reg.setBloodgroup(result.getString("bloodgroup"));
			
		} 
		ps.close();	
		return reg;		
	}

	public static boolean updateEmployee(Register reg) throws SQLException, ClassNotFoundException
	{
		String sql = "UPDATE `employee` SET `eid` = ? , `logid` = ? , `rid` = ? , `ename` = ? , `eadd` = ? , `emno` = ? , `eemail`  = ? , `password`  = ? , `edob` = ? , `egender` = ? , `city`  = ? , `state` = ? , `bloodgroup` = ? WHERE `eid`  = ? ;";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		ps.setInt(1,reg.getEid());
		ps.setInt(2,reg.getLogid());
		ps.setInt(3,reg.getRid());
		ps.setString(4,reg.getEname());
		ps.setString(5,reg.getEadd());
		ps.setString(6,reg.getEmno());
		ps.setString(7,reg.getEemail());
		ps.setString(8,reg.getPassword());
		ps.setString(9,reg.getEdob());
		ps.setString(10,reg.getEgender());
		ps.setString(11,reg.getCity());
		ps.setString(12,reg.getState());
		ps.setString(13,reg.getBloodgroup());
		ps.setInt(14,reg.getEid());
		int result = ps.executeUpdate();  
		boolean flag = false;  
		if(result == 1)
		{			
			String sqlLogin = "UPDATE `login` SET `eid` = ? , `logid` = ? , `rid` = ? , `password`  = ? WHERE `eid`  = ? ;";
			PreparedStatement ps2 = (PreparedStatement) JdbcConn.getConnection(sqlLogin); // con.prepareStatement(sql);  				
			ps2.setInt(1,reg.getEid());
			ps2.setInt(2,reg.getLogid());
			ps2.setInt(3,reg.getRid());
			ps2.setString(4,reg.getPassword());
			ps2.setInt(5,reg.getEid());
			int result2 = ps2.executeUpdate();  
			if(result2 == 1)
			{
				flag = true;	
			}
		}
		ps.close(); 
		return flag;
		
	}
}
