package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
// import java.lang.*;
import model.Register;
import util.JdbcConn;

public class RegisterDao {

	public RegisterDao() {
		// TODO Auto-generated constructor stub
	}
	public static boolean register(Register reg) throws SQLException, ClassNotFoundException
	{
	//	String sql = "INSERT INTO `employee`(`eid`, `logid`, `rid`, `ename`, `eadd`, `emno`, `eemail`, `password`, `edob`, `egender`, `city`, `state`, `bloodgroup`) VALUES ('"+reg.getEid()+"', '"+reg.getLogid()+"','"+reg.getRid()+"','"+reg.getEname()+"','"+reg.getEadd()+"','"+reg.getEmno()+"','"+reg.getEemail()+"','"+reg.getPassword()+"','"+reg.getEdob()+"','"+reg.getEgender()+"','"+reg.getCity()+"','"+reg.getState()+"' , '"+reg.getBloodgroup()+"')";  
		String sql = "INSERT INTO `employee`(`eid`, `logid`, `rid`, `ename`, `eadd`, `emno`, `eemail`, `password`, `edob`, `egender`, `city`, `state`, `bloodgroup`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
	//	ps.setInt(1,logininfo.getLogid());
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
		
		int result1 = ps.executeUpdate();  
		boolean flag = false;  
		if(result1 == 1)
		{	
			String sqlLogin = "INSERT INTO `login`(`logid`, `eid`, `password`, `rid`) VALUES (?,?,?,?)";
			PreparedStatement ps2 = (PreparedStatement) JdbcConn.getConnection(sqlLogin); // con.prepareStatement(sqlLogin);
			ps2.setInt(1,reg.getLogid());
			ps2.setInt(2,reg.getEid());
			ps2.setString(3,reg.getPassword());
			ps2.setInt(4,reg.getRid());
			int result2 = ps2.executeUpdate();
			if(result2 == 1)
			{
				flag = true;
			}
			ps2.close();
		}
		ps.close(); 
		return flag;
		
	}


}
