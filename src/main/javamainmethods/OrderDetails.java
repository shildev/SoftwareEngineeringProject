package com1028_coursework;

public class OrderDetails {
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;

	/**
	 * Class constructor is below
	 * 
	 * @param order number
	 * @param product code
	 * @param quantity ordered
	 * @param price for each product
	 * @param order line number
	 */
	public OrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach,
			int orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

	public int getOrderNumber() { /**  getters to allow object variables to be available to use */
		return orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

}
