package dbproperty;

public interface DbProperty 
{
	//public static final String DB_CLASS="oracle.jdbc.driver.OracleDriver";
	public static final String DB_CLASS="com.mysql.jdbc.Driver";
	//public static final String DB_URL="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String DB_URL="jdbc:mysql://testinstance.cepntvy13fmb.us-west-2.rds.amazonaws.com:3306/floodproject";
	public static final String USER="soumya";
	public static final String PWD="abcd1234";
}


