package Ecommerce;

public class OrderDetails {

	private String productOrderedId;
	public String getProductOrderedId() {
		return productOrderedId;
	}
	public void setProductOrderedId(String productOrderedId) {
		this.productOrderedId = productOrderedId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String country;
}
