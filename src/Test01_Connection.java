//Program #1: Sample program to connect to Oracle DB
//Test01_Connection.java
import java.sql.*;
class Test01_Connection {
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	   
	//1. Load DB driver implementation class
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("OracleDriver is loaded");
	System.out.println("Hello:");
	System.out.println("Manideep L");
	//2. Establishing connection
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Manager"
			 );
	System.out.println("Connection is created");
	System.out.println("con: "+ con);
	
   }//main method close
}//class close

/*
Compilation and Execution
==========================
1. Save above program with the name Test01_Connection
   in the folder "D:\FSJD\04 AJ\01JDBC"

2. Open command prompt pointing to the above folder path 

3. we must set classpath to Oracle JDBC Driver software jar file
	cmd>set classpath=.;C:\Oracle21c\dbhomeXE\jdbc\lib\ojdbc11.jar

	cmd>javac Test01_Connection.java
			|->	Test01_Connection.java
			
	cmd>java Test01_Connection
	      Output
			Connection is created
			con: oracle.jdbc.driver.T4CConnection@5d47c63f
*/