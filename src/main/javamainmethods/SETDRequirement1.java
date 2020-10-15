package com1028_coursework;

import java.sql.SQLException;

/**Requirement 1 of Set D; for the payments to be both retrieved and displayed to the user
 * 1.Report those payments greater than $100,000.*/

public class SETDRequirement1 {
	public static void main(String[] args) throws SQLException{
		/**for the first test, a new object will be created for the main test method. 
		 * As this is for the payment display method, the payments will be retrieved then displayed. The connection will then close
		 */
		PaymentMethod pay = new PaymentMethod();
		pay.getPayments();
		pay.DisplayPayments();
		pay.TerminateConnection();
		
		
		
	}
}
