/*
Program #3:
	Develop a JDBC program to create a table student
	with columns 'sno, sname, course, fee'
	in the schema(user) hknit4pm 

	Query: (DDL)
		CREATE TABLE student(
			sno		NUMBER(4) PRIMARY KEY,
			sname	VARCHAR2(15),
			course	VARCHAR2(15),
			fee		NUMBER(6, 2)
		);

	JDBC method:
		boolean execute(query)
*/
//Test03_TableCreation.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

class  Test03_TableCreation {
	public static void main(String[] args) 
						throws ClassNotFoundException, SQLException {

	//loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

	//establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hknit4pm", "hari");

	//creating statement object
		Statement stmt = con.createStatement();

	//executing query for creating table
		stmt.execute(
			"CREATE TABLE student(					"	+
			"		sno		NUMBER(4) PRIMARY KEY,	"	+
			"		sname	VARCHAR2(20),			"	+
			"		course	VARCHAR2(20),			"	+
			"		fee		NUMBER(10, 2)			"	+
			"	)									"
		);
		
		System.out.println("Table is created successfully");

	//closing connections
		stmt.close();
		con.close();

	}//main close

}//class close
