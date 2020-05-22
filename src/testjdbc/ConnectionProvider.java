package testjdbc;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider extends TestJdbs
{
	
	public static Connection  provideConnection()
	{
		Connection con=null;
		try {
			FileInputStream fis = new FileInputStream(".//resource//connection.properties");
			Properties p1 = new Properties();
			p1.load(fis);
			String driver = p1.getProperty("drivername");
			String url = p1.getProperty("url");
			String user = p1.getProperty("username");
			String password = p1.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user,"");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
