/*
Program #7:
	Develop program to insert rows in student table 
	with dynamic INSERT query by using Prepared Statement
	by reading student details from keyboard from end-user
*/

//Test07_InsertRows_Pstmt.java
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class  Test07_InsertRows_Pstmt {
	public static void main(String[] args) 
						throws ClassNotFoundException, SQLException {

	//1. loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

	//2. establishing connection
		Connection con = 
			DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hknit4pm", "hari");

	//3. creating PreparedStatement object
		PreparedStatement pstmt = 
			con.prepareStatement(
				"""
				INSERT INTO student(sno, sname, course, fee)
				VALUES(?, ?, ?, ?)
				"""	
			);

	//4. executing the query available in stmt/psmt
			Scanner scn = new Scanner(System.in);
			String option = "N";
			int count = 1;
			do {
			  //1. reading values for query place holders 
			  		System.out.println("Enter student"+ count++ + " details");
					System.out.print("  Enter sno\t: ");
					int		sno		= scn.nextInt();	scn.nextLine();

					System.out.print("  Enter sname\t: ");
					String	sname	= scn.nextLine();	

					System.out.print("  Enter course\t: ");
					String  course  = scn.nextLine();

					System.out.print("  Enter fee\t: ");
					double  fee     = scn.nextDouble();

			  //2. setting those values to pstmt 
					pstmt.setInt(1, sno);
					pstmt.setString(2, sname);
					pstmt.setString(3, course);
					pstmt.setDouble(4, fee);

			  //3. execute pstmt
					pstmt.executeUpdate();	
					System.out.println("Student data is saved");

					System.out.print("\nDo you want enter another student(Y/N)?: ");
					option = scn.next();

			}while(option.equalsIgnoreCase("Y"));

	//5. closing connections
		pstmt.close();
		con.close();

	}//main close

}//class close
