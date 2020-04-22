package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payroll;
import util.JdbcConn;

public class UpdatePayrollDao {

	public UpdatePayrollDao() {
		// TODO Auto-generated constructor stub
	}

	public static Payroll getData(long id) throws SQLException, ClassNotFoundException
	{
		Payroll pay = new Payroll();
		String sql = "SELECT * FROM `payroll`  WHERE `payrollid` = ? ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ps.setLong(1,id);
		ResultSet result = ps.executeQuery();  
		while(result.next()) 
		{  
			pay.setPayrollid(result.getLong("payrollid"));
			pay.setEid(result.getInt("eid"));
			pay.setPayrolltype(result.getString("payrolltype"));
			pay.setAmount(result.getInt("amount"));
			pay.setPayrolldate(result.getString("payrolldate"));
			pay.setPayrollmonth(result.getString("payrollmonth"));
		} 
		ps.close();	
		return pay;		
	}
	
	public static boolean updatePayroll(Payroll pay) throws SQLException, ClassNotFoundException
	{
		// String sql = "UPDATE `project` SET `eid` = '"+prj.getEid()+"', `logid` = '"+prj.getLogid()+"', `rid` = '"+prj.getRid()+"', `ename` = '"+prj.getEname()+"', `eadd` = '"+prj.getEadd()+"', `emno` = '"+prj.getEmno()+"', `eemail`  = '"+prj.getEemail()+"', `password`  = '"+prj.getPassword()+"', `edob` = '"+prj.getEdob()+"', `egender` = '"+prj.getEgender()+"', `city`  = '"+prj.getCity()+"', `state` = '"+prj.getState()+"', `bloodgroup` = '"+prj.getBloodgroup()+"' WHERE `eid`  = '"+prj.getEid()+"' ;";
		// String sql = " UPDATE `project` SET `pid` = '"+prj.getPid()+"' , `eid` = '"+prj.getEid()+"' , `pname` = '"+prj.getPname()+"' , `clientname` = '"+prj.getClientname()+"' , `programminglanguage` = '"+prj.getProgramminglanguage()+"' , `databasetechnology` = '"+prj.getDatabasetechnology()+"' , `pcost` = '"+prj.getPcost()+"' , `psdate` = '"+prj.getPsdate()+"' , `pedate` = '"+prj.getPedate()+"' , `pdes` = '"+prj.getPdes()+"' WHERE `pid` = '"+prj.getPid()+"' " ;
		//String sql = " UPDATE `payroll` SET eid , `payrolltype` = '"++"' WHERE `eid` = '"+pay.getEid()+"' ; " ;
		String sql = " UPDATE `payroll` SET `eid`= ? , `payrolltype`= ? , `amount`= ? , `payrolldate`= ? , `payrollmonth`= ? WHERE `payrollid` = ? ; " ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  				
		ps.setInt(1,pay.getEid());
		ps.setString(2,pay.getPayrolltype());
		ps.setInt(3,pay.getAmount());
		ps.setString(4,pay.getPayrolldate());
		ps.setString(5,pay.getPayrollmonth());
		ps.setLong(6,pay.getPayrollid());
		
		int result = ps.executeUpdate();  
		boolean flag = false;  
		if(result == 1)
		{			
				flag = true;			
		}
		
		ps.close(); 
		return flag;
		
	}

	
}
