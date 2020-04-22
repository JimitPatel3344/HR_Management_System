/**
 * 
 */
package util;
import java.sql.*;

/**
 * @author AARTI
 *
 */
public class JdbcConn {

	public static Statement getConnection(String sql) throws SQLException,ClassNotFoundException
	{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diplomaproject","root","");
			return con.prepareStatement(sql);
		
	}
/*	public JdbcConn() {
		// TODO Auto-generated constructor stub
		
	}
*/

}
