package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Payroll;
import util.JdbcConn;

public class DisplayPayrollDao {

	public DisplayPayrollDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Payroll> displayPayrollDetails() throws SQLException, ClassNotFoundException
	{
//String sql = "SELECT eid, logid, rid, ename, eadd, emno, eemail, password, edob, city, state, bloodgroup FROM `employee` ; ";
		String sql = "SELECT * FROM `payroll` ORDER BY payrollid ; ";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		ResultSet result = ps.executeQuery();  
		List<Payroll> payList = new ArrayList<Payroll>();
		while(result.next()) 
		{  
			Payroll pa = new Payroll();
			pa.setPayrollid(result.getLong("payrollid"));
			pa.setEid(result.getInt("eid"));
			pa.setPayrolltype(result.getString("payrolltype"));
			pa.setAmount(result.getInt("amount"));
			pa.setPayrolldate(result.getString("payrolldate"));
			pa.setPayrollmonth(result.getString("payrollmonth"));
			payList.add(pa);
		} 
		ps.close(); 
		return payList;		
	}
	
	public static int countPayroll() throws ClassNotFoundException, SQLException
	{
		int count=0;
		String sql = " SELECT COUNT(*) FROM `payroll` ; "  ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);
		ResultSet result = ps.executeQuery();  
		while(result.next())
		{
			count = result.getInt(1);
		}
		
		return count;
	}

}
