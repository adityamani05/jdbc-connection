package testjdbc;

import java.sql.Connection;

public interface Services 
{
	public void executeSelect(Connection con);
	public void executeUpdate(Connection con);
	//public Connection  provideConnection();
}
