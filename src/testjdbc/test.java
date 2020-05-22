package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class test 
{
	private Connection con;

	private PreparedStatement smt;
	
	Resultset rs;
	
	
	public  void main(String [] args)
	{

	
		try {
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
		smt = con.prepareStatement("Select * from user where username=akash");
		rs=(Resultset) smt.executeQuery();
		while(((ResultSet) rs).next())
		{
			String s1 = ((ResultSet) rs).getString(1);
			String s2 = ((ResultSet) rs).getString(2);
			System.out.println(s1+s2);
		}
		
	} 
		
		
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
