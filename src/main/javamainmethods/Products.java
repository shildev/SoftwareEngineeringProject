package com1028_coursework;

public class Products {
	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double MSRP;
	/**
	 *  Class constructor is below
	 * 
	 * @param MSRP 
	 * @param product code
	 * @param product name
	 * @param the product line
	 * @param product scale
	 * @param product's vendor
	 * @param product description
	 * @param quantity of stock of the product
	 * @param price the product is bought for
	 * @param Manufacturer's Suggested Retail Price
	 */
	public Products(String productCode, String productName, String productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = MSRP;
	}
	public String getProductCode() {  /** getters to allow object variables to be available to use */
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductLine() {
		return productLine;
	}
	public String getProductScale() {
		return productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public double getMSRP() {
		return MSRP;

	}
	
}
	
