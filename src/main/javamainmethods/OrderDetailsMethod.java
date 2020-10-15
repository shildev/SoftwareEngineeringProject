package com1028_coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


/**Method which allows access to the order details table*/
public class OrderDetailsMethod {

	DatabaseConnection con = new DatabaseConnection();
	Connection databaseconnection = con.get_connection();
	Statement stmnt = null;
	ResultSet rs = null;
	
	/**Method below ensures that the data from the database is inserted into
	 * an ArrayList for the OrderDetails which can be later used.
	 * Reference: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#:~:text=Creating%20Statements,to%20create%20a%20Statement%20object. */
	
	public List<OrderDetails> getOrderDetails() throws SQLException{
		ArrayList<OrderDetails> orderdetails = new ArrayList<OrderDetails>();
		try {
			Statement stmnt = databaseconnection.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM OrderDetails"); //query executed and data is selected from the OrderDetails part of the database 
			
		/**While loop is created to allow for each element in the result set to be iterated for order details data to be stored*/
			while(rs.next()) {
				int orderNumber = rs.getInt("orderNumber");
				String productCode = rs.getString("productCode");
				int quantityOrdered = rs.getInt("quantityOrdered");
				double priceEach = rs.getDouble("priceEach");
				int orderLineNumber = rs.getInt("orderLineNumber");
				orderdetails.add(new OrderDetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber));
				
				
				
				/**Exception for when or if the records cannot be retrieved */	
			}
		} catch (SQLException e) {
			System.out.println("Unfortunately, the records could not be retrieved. Try again maybe?");
			throw new RuntimeException(e); 
		}
		return orderdetails;
}

	/**After the sufficient data is retrieved, the connection is then terminated. */
	public void TerminateConnection() {

		try {
			if (this.stmnt != null) {
				this.stmnt.close();
			}
			if (this.databaseconnection != null) {
				this.databaseconnection.close();
			}
			System.out.println("Connection to the database has been closed. Thanks for checking in.");
		} catch (Exception e) {
			System.out.print("Hmm...it seems that the connection to the database failed to close...");
			throw new RuntimeException(e);
		}
	}

}
	
			
			
			
	
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	

