package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Payroll;
import util.JdbcConn;

public class AddSalaryDao {

	public AddSalaryDao() {
		// TODO Auto-generated constructor stub
	}

	public static boolean addPayroll(Payroll pay) throws SQLException, ClassNotFoundException
	{
		boolean flag = false; 
		String sql = " INSERT INTO `payroll`(`eid`, `payrolltype`, `amount`, `payrolldate`, `payrollmonth`) VALUES (?,?,?,?,?) ; " ;
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql); // con.prepareStatement(sql);  
		// ps.setInt(1,logininfo.getLogid());		
		ps.setInt(1,pay.getEid());		
		ps.setString(2,pay.getPayrolltype());
		ps.setInt(3,pay.getAmount());
		ps.setString(4,pay.getPayrolldate());
		ps.setString(5,pay.getPayrollmonth());		
						
		int result1 = ps.executeUpdate();  
		 
		if(result1 == 1)
		{	
			flag = true;
		}
		
		ps.close(); 
		return flag;		
	
	}
	
}
