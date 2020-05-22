package testjdbc;

import java.sql.*;

public class TestJdbs /*extends ConnectionProvider*/ implements Services
{
	private Connection con;
	private Statement stmt;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int updateCounter=0;
	
	/*public void Connect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			stmt = con.createStatement();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public void executeSelect(Connection con)
	{
		int eNo = 0;
		String eName = " ";
		int eSal = 0;
		try
		{
			//rs=stmt.executeQuery("select * from Employee");
			psmt=con.prepareStatement("select * from employee where eId=? ");
			psmt.setInt(1, 101);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				eNo = rs.getInt(1);
				eName = rs.getString(2);
				eSal = rs.getInt(3);
				System.out.println(eNo +"  "+eName+"  " +eSal);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void executeUpdate(Connection con)
	{
		try
		{	
			stmt = con.createStatement();
			updateCounter=stmt.executeUpdate("Insert into Employee values(105,'Aditya',25000);");
			if(updateCounter!=0)
			{
				System.out.println("ONE EMPLOYEE ADDED");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/*public static void main(String[] args)
	{
		TestJdbs tj = new TestJdbs();
		tj.con = ConnectionProvider.provideConnection();
		try {
			tj.stmt =tj.con.createStatement();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tj.executeSelect(tj.con);
		//tj.executeUpdate();
		//tj.executeSelect();
		try {
			//c.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
