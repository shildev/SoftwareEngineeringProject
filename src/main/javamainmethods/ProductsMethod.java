package com1028_coursework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Statement;

/** Method which allows access to the products table */

public class ProductsMethod {
	DatabaseConnection con = new DatabaseConnection();
	Connection databaseconnection = con.get_connection();
	
	Statement stmnt = null;
	ResultSet rs = null;

	/**
	 * Method below ensures that the data from the database is inserted into an
	 * ArrayList for the Products details which can be later used. Reference:
	 * https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html#
	 */
	public List<Products> getProducts() throws SQLException {
		ArrayList<Products> products = new ArrayList<Products>();
		try {
			/**
			 * From the requirements set; it is needed to "Report the products that have not been 
				sold." Therefore, we need to access the database and make sure to only display products 
				which have not been ordered. The productCode attribute is present in both products and orderdetails.
				Therefore, we can select the product codes which do not exist in the orderdetails table.
			 */
			Statement stmnt = databaseconnection.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM Products WHERE Products.productCode NOT IN (SELECT OrderDetails.productCode FROM OrderDetails);");
			/**
			 * While loop is created to allow for each element in the result set to be
			 * iterated for order products data to be stored
			 */
			
			while (rs.next()) {
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				String productLine = rs.getString("productLine");
				String productScale = rs.getString("productScale");
				String productVendor = rs.getString("productVendor");
				String productDescription = rs.getString("productDescription");
				int quantityInStock = rs.getInt("quantityInStock");
				double buyPrice = rs.getDouble("buyPrice");
				double MSRP = rs.getDouble("MSRP");
				products.add(new Products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP));
				
			
			}

		} catch (SQLException e) {
			System.out.println("Unfortunately, the records could not be retrieved. Try again maybe?");
			throw new RuntimeException(e);
		}
		return products;
	}

	/**
	 * After the correct data is selected, it must now be displayed to the user as
	 * shown via the following method:
	 */

	public void DisplayProductsNotSold() throws SQLException {
		List<Products> products = getProducts();
		Iterator<Products> iterate = products.iterator();// Iterator is needed to iterate through the arraylist

		Products showthatobject;
		while (iterate.hasNext()) {
			showthatobject = iterate.next();
			System.out.println("Here are the details of the products not sold...");
			System.out.println("Product Code: " + showthatobject.getProductCode());
			System.out.println("Product Name: " + showthatobject.getProductName());
			System.out.println("Product Line: " + showthatobject.getProductLine());
			System.out.println("Product Scale: " + showthatobject.getProductScale());
			System.out.println("Product Vendor: " + showthatobject.getProductVendor());
			System.out.println("Product Description: " + showthatobject.getProductDescription());
			System.out.println("Product Quantity In Stock: " + showthatobject.getQuantityInStock());
			System.out.println("Price that product is bought for: " + showthatobject.getBuyPrice());
			System.out.println("Manufacturer's Suggested Retail Price: " + showthatobject.getMSRP());
		
		
		
		
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

