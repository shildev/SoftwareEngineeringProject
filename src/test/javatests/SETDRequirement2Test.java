package com1028_coursework_tests;

//2.Report the products that have not been sold.
import static org.junit.Assert.*;
import java.sql.*;

import com1028_coursework.DatabaseConnection;

import com1028_coursework.Products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SETDRequirement2Test {

	public void test2() {

		DatabaseConnection con = new DatabaseConnection();
		
		try (Connection connection = con.get_connection()) {
			try (Statement stmnt = connection.createStatement()) {
				connection.setAutoCommit(false);

				// To make sure the payments table is clear before testing

				String productCode = "S18_3233";
				String productName = "1985 Toyota Supra";
				String productLine = "Classic Cars";
				String productScale = "1:18";
				String productVendor = "Highway 66 Mini Classics";
				String productDescription = "This model features soft rubber tires, working steering, rubber mud guards, authentic Ford logos, detailed undercarriage, opening doors and hood, removable split rear gate, full size spare mounted in bed, detailed interior with opening glove box";
				int quantityInStock = 7733;
				double buyPrice = 57.01;
				double MSRP = 107.57;

				Products product = new Products(productCode, productName, productLine, productScale, productVendor,
						productDescription, quantityInStock, buyPrice, MSRP);

				assertEquals(productCode, product.getProductCode());
				assertEquals(productName, product.getProductName());
				assertEquals(productLine, product.getProductLine());
				assertEquals(productScale, product.getProductScale());
				assertEquals(productVendor, product.getProductVendor());
				assertEquals(productDescription, product.getProductDescription());
				assertEquals(quantityInStock, product.getQuantityInStock());
				assertEquals(buyPrice, product.getBuyPrice(), 0.14);
				assertEquals(MSRP, product.getMSRP(), 0.21);

				
				try (ResultSet resultset = stmnt.executeQuery("SELECT * FROM Products WHERE Products.productCode NOT IN (SELECT OrderDetails.productCode FROM OrderDetails)")) {
					assertTrue(resultset.next());
					assertEquals(productCode, resultset.getString("productCode"));
					assertEquals(productName, resultset.getString("productName"));
					assertEquals(productLine, resultset.getString("productLine"));
					assertEquals(productScale, resultset.getString("productScale"));
					assertEquals(productVendor, resultset.getString("productVendor"));
					assertEquals(productDescription, resultset.getString("productDescription"));
					assertEquals(quantityInStock, resultset.getString("quantityInStock"));
					assertEquals(buyPrice, resultset.getString("buyPrice"));
					assertEquals(MSRP, resultset.getString("MSRP"));

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
			fail(exc.toString());/** Fails a test and returns a short description of this throwable. */
		}
	}
}
