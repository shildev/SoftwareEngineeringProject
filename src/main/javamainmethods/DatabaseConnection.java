
package com1028_coursework;

/**
 * @author ss02209
 * Creating a connection to the classic models database
 *
 */


import java.sql.Connection;

import java.sql.DriverManager;

public class DatabaseConnection {
	protected Connection connection = null; //connection stored

	/**method for the connection to the database*/
	
	public Connection get_connection(){
		try {
		   	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "password"); 
		}
		/**connection is provided to the database, as well as a username/password for the server*/
		catch(Exception e) {
			System.out.println("You failed to connect to the database");
			throw new RuntimeException(e); // the case exception for when the connection fails
		}
		return connection;
	}

}
