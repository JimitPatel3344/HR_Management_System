package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.JdbcConn;

public class DeleteTaskDao {

	public DeleteTaskDao() {
		// TODO Auto-generated constructor stub
	}

	public static boolean deleteTask(int id) throws SQLException, ClassNotFoundException
	{
		boolean flag = false;
		String sql = "DELETE FROM `task` WHERE `tid` = ? ;";
		PreparedStatement ps = (PreparedStatement) JdbcConn.getConnection(sql);
		ps.setInt(1,id);
		int numberOfRowsAffected = ps.executeUpdate();
		if(numberOfRowsAffected == 1)
		{
			flag = true;
		}
		ps.close();	 return flag;
	}
}
