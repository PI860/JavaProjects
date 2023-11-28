package ThisAndThatJDBCsol.src;

import java.sql.*;

public class DBConnectionTest {
	private static Connection con;
	
	public static void main(String[] args) throws SQLException {
				
		try {
		    String localUrl = "jdbc:mysql://localhost:3306/"; 	 // local MySQL server
		    String db = "user01_thisandthat";  			 // Database name
		    String user = "user01";			 // a user on this db
		    String pw = "user01";			 // password
		    
		   // Class.forName("com.mysql.cj.jdbc.Driver");
		    
		    con = DriverManager.getConnection(localUrl + db /*+ "?useSSL=false"*/, user, pw );  // Connecting to database

		    con.setAutoCommit(false); // Configuring connection, e.g. switch off auto-commit mode!
		    Article.DBConnectionTest.testConnection(); // Connecting to MySQL V8.x
		   
		} catch (Exception e){ 
			   System.out.println(e.getMessage()); e.printStackTrace();
		} finally {
			   con.close();
		}


		
	}
	
	private static void testConnection() throws Exception{
		System.out.println ("testConnection: Selecting rows from table CUSTOMER");
				 try {
				   // Statement object for select statement
				   Statement sta = con.createStatement();
				   // Selecting something by applying joins 
				   ResultSet res = sta.executeQuery("SELECT SALUTATION, FIRSTNAME, LASTNAME" 
				   + " FROM CUSTOMER;");
				   String anrede, vorname, nachname;
				   System.out.println(" SALUTATION          FIRSTNAME      LASTNAME\n" +
						   "-------------------------------------------\n");
				   while (res.next()){
				     anrede = res.getString("SALUTATION"); 
				     nachname =  res.getString("LASTNAME");
				     vorname =  res.getString("FIRSTNAME");
				     System.out.println(anrede + vorname + nachname);
				   }

				   sta.close(); 
				   res.close();
				 } catch (Exception e){ 
				   System.out.println(e.getMessage());
				   e.printStackTrace();
				 } 
				

	}

}
