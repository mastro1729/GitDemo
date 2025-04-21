	/*
Program #4:
	Develop a JDBC program to insert records in student table

	Query: (DML)
		INSERT INTO student(sno, sname, course, fee)
		VALUEs(101, 'Hari Krishna', 'Full Stack Java', 20000);

		INSERT INTO student(sno, sname, course, fee)
		VALUEs(102, 'Balayya Babu', 'Acting', 30000);

		INSERT INTO student(sno, sname, course, fee)
		VALUEs(103, 'Pavan Kalyan Babu', 'Politics', 10000);

	JDBC method:
		public int executeUpdate(query)
	
*/

//Test04_InsertRows.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

class  Test04_InsertRows {
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

	//executing query for inserting rows
		stmt.executeUpdate(
			"INSERT INTO student(sno, sname, course, fee)         "+
			"VALUES(101, 'Hari Krishna', 'Full Stack Java', 20000)"
		);

		stmt.executeUpdate(
			"INSERT INTO student(sno, sname, course, fee)"+
			"VALUES(102, 'Balayya Babu', 'Acting', 30000)"
		);
	 
		stmt.executeUpdate(
			"INSERT INTO student(sno, sname, course, fee)       "+
			"VALUES(103, 'Pavan Kalyan Babu', 'Politics', 10000)"
		);

		System.out.println("Rows are inserted successfully");

	//closing connections
		stmt.close();
		con.close();

	}//main close

}//class close
