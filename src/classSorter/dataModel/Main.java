package classSorter.dataModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
      
			        try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations

		            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		        } catch (Exception ex) {
		            // handle the error
		        }	
	try (
	         // Step 1: Allocate a database 'Connection' object
	         Connection conn = DriverManager.getConnection(
	        		 "jdbc:mysql://localhost:3306/sortingapp?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
		               "root", "");   // For MySQL only
	               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
	 
	         // Step 2: Allocate a 'Statement' object in the Connection
	         Statement stmt = conn.createStatement();
	      ) {
	         // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
	         String strSelect = "select * from customer";
	         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
	  
	         ResultSet rset = stmt.executeQuery(strSelect);
	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            String name = rset.getString("name");
	            int storeid = rset.getInt("category_id");
	            int    addressid   = rset.getInt("grade");
	            System.out.println(name + ", " + storeid + ", " + addressid);
	            ++rowCount;
	         }
	         System.out.println("Total number of records = " + rowCount);
	 
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      }
			// Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
	
	   }

}
