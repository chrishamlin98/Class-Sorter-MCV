package classSorter.dataModel;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	// Creating instances for my DB swing utility (VIDEO BEANS @ 0:44)

	String MyConnection = 
	
	private static database instance = new database();
	
	
	 public static void main(String[] args) {
		 
		 String url = "jdbc:mysql://localhost:3306/behavior?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		 String user = "root";
		 String pw = "root";
		 
	      try (
	         // Step 1: Allocate a database 'Connection' object
	         java.sql.Connection conn = DriverManager.getConnection(url, user, pw);   // For MySQL only
	               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	
	 
	         // Step 2: Allocate a 'Statement' object in the Connection
	         Statement stmt = conn.createStatement();
	      ) {
/*
	         // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
	         String strSelect = "select title, price, qty from books";
	         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
	 
	         ResultSet rset = stmt.executeQuery(strSelect);
*/	         
/*	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            String title = rset.getString("title");
	            double price = rset.getDouble("price");
	            int    qty   = rset.getInt("qty");
	            System.out.println(title + ", " + price + ", " + qty);
	            ++rowCount;
	         }
	         System.out.println("Total number of records = " + rowCount);
*/	 
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
	   }
	}