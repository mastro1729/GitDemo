/*
Program #6:
	Develop program to display a table columns names and rows data\

	Query: (DQL)
		SELECT * FROM student;

	JDBC method:
		public ResultSet executeQuery(selectQuery)
		public ResultSetMetaData getMetaData()
					 
*/

//Test06_ColumnsAndRows.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class  Test06_ColumnsAndRows {
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

		//Obtaining ResultSetMetaData object
		ResultSetMetaData rsmd = rs.getMetaData();

		int numberOfColumns = rsmd.getColumnCount();
		for(int columnIndex=1; columnIndex<=numberOfColumns; columnIndex++){
			System.out.print(rsmd.getColumnName(columnIndex) + "\t\t");
		}
		System.out.println();

	//5. featching results from DB to java program and printing on console
		while(rs.next()) {        
				int sno			= rs.getInt(1);		   	  
				String sname	= rs.getString(2);		   	  
				String course	= rs.getString(3);		   	  
				double fee		= rs.getDouble(4);		   	  

				System.out.println(sno + "\t"+sname+"\t\t"+course+"\t"+fee);

		}//while close					      

	//6. closing connections
		rs.close();
		stmt.close();
		con.close();

	}//main close

}//class close
