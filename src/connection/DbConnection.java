package connection;

import java.sql.*;
import static dbproperty.DbProperty.*;


public class DbConnection 
{
	Connection con;
	public DbConnection()
	{
		try
		{
			Class.forName(DB_CLASS);
			System.out.println("Driver load success");
		}
		catch(Exception e)
		{
			System.out.println("Driver load failed");
		}
	}
	
	public Connection setConnection()
	{
		try
		{
			con =DriverManager.getConnection(DB_URL,USER,PWD);
			System.out.println("DB Connection success");
			return con;
		}
		catch(Exception e)
		{
			System.out.println("Exception in set connection. DB connection failed. Check creds");
			e.printStackTrace();
			return null;
		}
		
		
	}

}
