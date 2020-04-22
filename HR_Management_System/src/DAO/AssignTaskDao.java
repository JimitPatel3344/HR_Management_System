package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Task;
import util.JdbcConn;

public class AssignTaskDao {

	public AssignTaskDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean addTask(Task tas) throws SQLException, ClassNotFoundException
	{
		boolean flag = false; 
		int destinationeid=0;	int pid=0;
	//  String sql = " INSERT INTO `task`(`eid`, `tasrolltype`, `amount`, `tasrolldate`, `tasrollmonth`) VALUES (?,?,?,?,?) ; " ;
		String sqle = "SELECT eid FROM `employee` WHERE `ename` = ? ; ";
		PreparedStatement pse = (PreparedStatement) JdbcConn.getConnection(sqle); // con.prepareStatement(sql);  
		pse.setString(1,tas.getDestinationEname());
		ResultSet resulte = pse.executeQuery();
		while(resulte.next())
		{
			destinationeid = resulte.getInt("eid");
		}
		
		String sqlp = "SELECT pid FROM `project` WHERE pname = ? ; ";
		PreparedStatement psp = (PreparedStatement) JdbcConn.getConnection(sqlp); // con.prepareStatement(sql);
		psp.setString(1,tas.getPname());
		ResultSet resultp = psp.executeQuery();
		while(resultp.next())
		{
			pid = resultp.getInt("pid");
		}
		
		String sqlt = " INSERT INTO `task` (`destination_eid`, `source_eid` , `destinationEname`, `pid`, `pname`, `tsdate`, `tedate`, `tpriority`, `tdes`, `tstatus`) VALUES (?,?,?,?,?,?,?,?,?,?) ; " ; 
		PreparedStatement pst = (PreparedStatement) JdbcConn.getConnection(sqlt); // con.prepareStatement(sql);  
		
	  //ps.setInt(1,logininfo.getLogid());	
      //pst.setInt(1,tas.getTid());
		pst.setInt(1,destinationeid);
		pst.setInt(2,tas.getSourceeid());
		pst.setString(3,tas.getDestinationEname());
		pst.setInt(4,pid);		
		pst.setString(5,tas.getPname());
		pst.setString(6,tas.getTsdate());
		pst.setString(7,tas.getTedate());
		pst.setString(8,tas.getTpriority());	
		pst.setString(9,tas.getTdes());
		pst.setInt(10,0);
						
		int resultt = pst.executeUpdate();  
		 
		if(resultt == 1)
		{	
			flag = true;
		}
		
		pst.close();	psp.close();	pse.close(); 
		return flag;		
	
	}


}
