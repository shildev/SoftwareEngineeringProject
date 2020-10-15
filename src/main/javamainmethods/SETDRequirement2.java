package com1028_coursework;

import java.sql.SQLException;

public class SETDRequirement2 {

	/** 2.Report the products that have not been sold. */
	public static void main(String[] args) throws SQLException {
		
		ProductsMethod p = new ProductsMethod();
		p.getProducts();
		p.DisplayProductsNotSold();
		p.TerminateConnection();
	}
}