package testjdbc;

public class Provider 
{
	public static Services getObject()
	{
		return new TestJdbs();
	}
}
