package testjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbProvider {
	Connection con;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement stmt;
		PreparedStatement psmt;
		Services s1 = Provider.getObject();
		 con = ConnectionProvider.provideConnection();
		s1.executeSelect(con);
		s1.executeUpdate(con);
	}

}
