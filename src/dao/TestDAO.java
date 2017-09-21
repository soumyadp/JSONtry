package dao;

import connection.DbConnection;
import java.sql.*;

public class TestDAO 
{
	DbConnection dbcon = new DbConnection();
	public static final String SQL = "select * from floodproject.flood where fdate <> '0000-00-00' limit 100;";
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet resultSet = null;
	
	public ResultSet getResultSet()
	{
		try
		{
			con = dbcon.setConnection();
			pst = con.prepareStatement(SQL);
			resultSet = pst.executeQuery();
		}
		catch(Exception e)
		{
			System.out.println("Error with result set");
			e.printStackTrace();
		}
		return resultSet;
	}

}
