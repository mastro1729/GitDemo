/*
Program #8:
	Develop program to update Adv Student's course as Adv Java, HTML
*/

//Test08_UpdateRows_Pstmt.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class  Test08_UpdateRows_Pstmt{
	public static void main(String[] args) 
						throws ClassNotFoundException, SQLException {

	//1. loading driver (optional from JDBC 4.0 onwards with feature 'Auto Loading'
		//Class.forName("oracle.jdbc.driver.OracleDriver");

	//2. establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hknit4pm", "hari");

	//3. creating PreparedStatement object
		PreparedStatement pstmt = 
			con.prepareStatement(
				"""
				UPDATE student
				SET course=?
				WHERE course=?
				"""	
			);

	//4. executing the query available in psmt
			  //1. set values to pstmt 
					pstmt.setString(1, "Adv Java, HTML");
					pstmt.setString(2, "Adv Java");

			  //2. execute pstmt
					int noOfRowsUpdated = pstmt.executeUpdate();	
					System.out.println(noOfRowsUpdated+ " student(s) data is updated");

	//5. closing connections
		pstmt.close();
		con.close();

	}//main close

}//class close
