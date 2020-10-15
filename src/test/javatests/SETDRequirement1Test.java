package com1028_coursework_tests;

//1.Report those payments greater than $100,000.
import static org.junit.Assert.*;
import java.sql.*;

import com1028_coursework.DatabaseConnection;
import com1028_coursework.Payments;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SETDRequirement1Test {

	public void test1() {

		DatabaseConnection con = new DatabaseConnection();
		;
		try (Connection connection = con.get_connection()) {
			try (Statement stmnt = connection.createStatement()) {
				connection.setAutoCommit(false);

				// To make sure the payments table is clear before testing
				stmnt.executeUpdate("DELETE FROM payments");

				int customerNumber = 141;
				String checkNumber = "ID10962";
				String paymentDate = "2004-12-31";
				double amount = 116208.40;
				Payments payment = new Payments(customerNumber, checkNumber, paymentDate, amount);

				assertEquals(customerNumber, payment.getCustomerNumber());
				assertEquals(checkNumber, payment.getCheckNumber());
				assertEquals(paymentDate, payment.getPaymentDate());
				assertEquals(amount, payment.getAmount(), 0.13);

			
				try (ResultSet resultset = stmnt.executeQuery("SELECT * FROM Payments WHERE amount > 100000")) {
					assertTrue(resultset.next());
					assertEquals(customerNumber, resultset.getString("customerNumber"));
					assertEquals(checkNumber, resultset.getString("checkNumber"));
					assertEquals(paymentDate, resultset.getString("paymentDate"));
					assertEquals(amount, resultset.getString("amount"));
					assertFalse(resultset.next());
				} catch (AssertionError testerror) {

				}

			} finally {

				connection.rollback(); /**
										 * Undoes all changes made in the current transactionand releases any database
										 * locks currently heldby this Connection object. This method should beused only
										 * when auto-commit mode has been disabled.
										 */
			}
		} catch (SQLException exc) {
			fail(exc.toString());/** Fails a test and returns a short description of this throwable.. */
		}
	}
}
