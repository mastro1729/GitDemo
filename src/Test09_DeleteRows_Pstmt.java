/*
Program #9:
	Develop program to delete rows from the table 
	based on the course value given from keyboard
*/

//Test09_DeleteRows_Pstmt.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class  Test09_DeleteRows_Pstmt{
	public static void main(String[] args) 
						throws SQLException {

	//1. establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hknit4pm", "hari");

	//2. creating PreparedStatement object
		PreparedStatement pstmt = 
			con.prepareStatement(
				"""
				DELETE FROM student
				WHERE course LIKE ?
				"""	
			);

	//3. set values to pstmt 
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter course to delete: ");
		pstmt.setString(1, "%"+scn.nextLine()+"%");

	//4. executing the query 
		int noOfRowsDeleted = pstmt.executeUpdate();	
		System.out.println(noOfRowsDeleted+ " student(s) data is deleted");

	//5. closing connections
		pstmt.close();
		con.close();

	}//main close

}//class close
