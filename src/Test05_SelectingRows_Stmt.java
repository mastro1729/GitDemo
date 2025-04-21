/*
Program #5:
	Develop a JDBC program to seclect rows from student table
	display all rows data on console

	Query: (DQL)
		SELECT * FROM student;

	JDBC method:
		public ResultSet executeQuery(selectQuery)
*/

//Test04_InsertRows.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class  Test05_SelectingRows {
	public static void main(String[] args) //7.handling exceptions
						throws ClassNotFoundException, SQLException {

	//1. loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

	//2. establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hknit4pm", "hari");

	//3. creating statement object
		Statement stmt = con.createStatement();

	//4. executing select query and obtaining ResultSet object
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");

	//5. featching results from DB to java program and printing on console
		while(rs.next()) {        
				int sno			= rs.getInt(1);		   	  
				String sname	= rs.getString(2);		   	  
				String course	= rs.getString(3);		   	  
				double fee		= rs.getDouble(4);		   	  

				System.out.println(sno + "\t"+sname+"\t\t"+course+"\t"+fee);

		}//while close					      

	/*
		rs-----> BFR	rs.next() -> moves cursor to next row-> returns true (r1)
			|--->	row1 101 HK  FSJD		20000    -> returns true (r2)
			|--->   row2 102 BK  Acting		30000	 -> returns true (r3)
			|--->	row3 103 PK  polotics	10000	 -> returns false(r4)(exit loop)
		    |--------> ALR  
		*/


	//6. closing connections
		rs.close();
		stmt.close();
		con.close();

	}//main close

}//class close
