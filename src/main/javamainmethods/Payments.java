package com1028_coursework;

public class Payments {
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private double amount;

	/**
	 * Class constructor is below
	 * 
	 * @param customer number
	 * @param check number
	 * @param payment date
	 * @param amount paid
	 */
	public Payments(int customerNumber, String checkNumber, String paymentDate, double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getCustomerNumber() { /** getters to allow object variables to be available to use */
		return this.customerNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public String getPaymentDate() {
		return this.paymentDate;
	}

	public double getAmount() {
		return this.amount;
	}

}
