/*
Program #2:
	Develop a JDBC program to create a schema(DB user)
	with the username hknit4pm with the password hari

	Queries: (DDL)
		ALTER SESSION SET \"_ORACLE_SCRIPT\"=true";
		CREATE USER hknit4pm IDENTIFIED BY hari"; 
		GRANT DBA to hknit4pm";                    

	JDBC method:
		boolean execute(query)

*/
//Test02_SchemaCreation.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

class  Test02_SchemaCreation {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	//loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

	//establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "Manager");

	//creating statement object
		Statement stmt = con.createStatement();

	//executing query for creating schema(user)
		System.out.println("Attempting to alter session");
		stmt.execute("ALTER SESSION SET \"_ORACLE_SCRIPT\"=true");
		System.out.println("Session altered successfully.");
		
		System.out.println("Attempting to create user");
		stmt.execute("CREATE USER hknit4pm IDENTIFIED BY hari");
		System.out.println("User created successfully.");
		
		System.out.println("Attempting to grant DBA privileges");
		stmt.execute("GRANT DBA to hknit4pm");
		System.out.println("DBA privileges granted successfully.");
		
		System.out.println("Schema is created, permissions are granted");

		//closing connections
		stmt.close();
		con.close();

	}//main close

}//class close
