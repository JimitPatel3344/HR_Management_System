package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Register;
import util.JdbcConn;

public class ForgotPasswordDao {

	public ForgotPasswordDao() {
		// TODO Auto-generated constructor stub
	}
	public static boolean changePassword(Register changePassword) throws ClassNotFoundException, SQLException
	{
		boolean flag = false;
		String sqle = " UPDATE `employee` SET `password` = ? WHERE `eid` = ? , `eemail` = ? , `ename` = ? ; " ;
		PreparedStatement pse = (PreparedStatement) JdbcConn.getConnection(sqle);
		pse.setString(1,changePassword.getPassword());
		pse.setInt(2,changePassword.getEid());
		pse.setString(3,changePassword.getEemail());
		pse.setString(4,changePassword.getEname());
		int numberOfAffectedRowsE = pse.executeUpdate();
		if (numberOfAffectedRowsE == 1)
		{
			String sqll = " UPDATE `login` SET `password` = ? WHERE `eid` = ? ; " ;
			PreparedStatement psl = (PreparedStatement) JdbcConn.getConnection(sqll);
			psl.setString(1,changePassword.getPassword());
			psl.setInt(2,changePassword.getEid());
			int numberOfAffectedRowsp = psl.executeUpdate();
			if (numberOfAffectedRowsp == 1)
			{
				flag = true;
			}
		}
		return flag;
	}

}
