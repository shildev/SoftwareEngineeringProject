package com1028_coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.Iterator;

/** Method which allows access to the payments table */
public class PaymentMethod {

	DatabaseConnection con = new DatabaseConnection();
	Connection databaseconnection = con.get_connection();
	Statement stmnt = null;
	ResultSet rs = null;

	/**
	 * Method below ensures that the data from the database is inserted into an
	 * ArrayList for the Payment details which can be later used. Reference:
	 * https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#
	 */

	public List<Payments> getPayments() throws SQLException {
		ArrayList<Payments> payments = new ArrayList<Payments>();
		try {
			Statement stmnt = databaseconnection.createStatement();
																	
			/**
			 * From the requirements set; it is needed to "Report those payments greater
			 * than $100,000." Therefore, we must select from the payments table where the
			 * amount exceeds 100,000
			 */
			ResultSet rs = stmnt.executeQuery("SELECT * FROM Payments WHERE amount > 100000");

			/**
			 * While loop is created to allow for each element in the result set to be
			 * iterated for payment details data to be stored
			 */
			while (rs.next()) {
				int customerNumber = rs.getInt("customerNumber");
				String checkNumber = rs.getString("checkNumber");
				String paymentDate = rs.getString("paymentDate");
				double amount = rs.getDouble("amount");
				payments.add(new Payments(customerNumber, checkNumber, paymentDate, amount));
			}

		} catch (SQLException e) {
			System.out.println("Unfortunately, the records could not be retrieved. Try again maybe?");
			throw new RuntimeException(e);
		}
		return payments;
	}

	/**
	 * After the correct data is selected, it must now be displayed to the user as
	 * shown via the following method:
	 */

	public void DisplayPayments() throws SQLException {
		List<Payments> payments = getPayments();
		Iterator<Payments> iterate = payments.iterator();// Iterator is needed to iterate through the arraylist

		Payments showthatobject;
		while (iterate.hasNext()) {
			showthatobject = iterate.next();
			System.out.println("Customer Number: " + showthatobject.getCustomerNumber());
			System.out.println("Check Number:" + showthatobject.getCheckNumber());
			System.out.println("Date of payment: " + showthatobject.getPaymentDate());
			System.out.println("Amount paid: " + showthatobject.getAmount() + "\n");

		}

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
	

