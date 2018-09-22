package com.webportal;

public class Product {

	private String id;
	private String product_name;
	private String product_type;
	private String product_variety;
	private String product_expairy;
	private String product_price;
	private String product_quantity;
	private String product_company;
	private String product_duration;
	private String store_name;
	private String product_type_organic;
	private String product_type_inorganic;
	private String product_type_machines;
	private String product_seeds;
	private String product_medicine;
	private String product_fertizer;
		
	

	public Product(String product_name, String product_type, String product_variety, String product_expairy,
			String product_price, String product_quantity, String product_company, String product_duration,
			String store_name, String product_type_organic, String product_type_inorganic, String product_type_machines,
			String product_seeds, String product_medicine, String product_fertizer) {
		super();
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_variety = product_variety;
		this.product_expairy = product_expairy;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_company = product_company;
		this.product_duration = product_duration;
		this.store_name = store_name;
		this.product_type_organic = product_type_organic;
		this.product_type_inorganic = product_type_inorganic;
		this.product_type_machines = product_type_machines;
		this.product_seeds = product_seeds;
		this.product_medicine = product_medicine;
		this.product_fertizer = product_fertizer;
	}

	public Product(String id, String product_name, String product_type, String product_variety, String product_expairy,
			String product_price, String product_quantity, String product_company, String product_duration,
			String store_name, String product_type_organic, String product_type_inorganic, String product_type_machines,
			String product_seeds, String product_medicine, String product_fertizer) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_variety = product_variety;
		this.product_expairy = product_expairy;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_company = product_company;
		this.product_duration = product_duration;
		this.store_name = store_name;
		this.product_type_organic = product_type_organic;
		this.product_type_inorganic = product_type_inorganic;
		this.product_type_machines = product_type_machines;
		this.product_seeds = product_seeds;
		this.product_medicine = product_medicine;
		this.product_fertizer = product_fertizer;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the product_type
	 */
	public String getProduct_type() {
		return product_type;
	}
	/**
	 * @param product_type the product_type to set
	 */
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	/**
	 * @return the product_variety
	 */
	public String getProduct_variety() {
		return product_variety;
	}
	/**
	 * @param product_variety the product_variety to set
	 */
	public void setProduct_variety(String product_variety) {
		this.product_variety = product_variety;
	}
	/**
	 * @return the product_expairy
	 */
	public String getProduct_expairy() {
		return product_expairy;
	}
	/**
	 * @param product_expairy the product_expairy to set
	 */
	public void setProduct_expairy(String product_expairy) {
		this.product_expairy = product_expairy;
	}
	/**
	 * @return the product_price
	 */
	public String getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the product_quantity
	 */
	public String getProduct_quantity() {
		return product_quantity;
	}
	/**
	 * @param product_quantity the product_quantity to set
	 */
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	/**
	 * @return the product_company
	 */
	public String getProduct_company() {
		return product_company;
	}
	/**
	 * @param product_company the product_company to set
	 */
	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}
	/**
	 * @return the product_duration
	 */
	public String getProduct_duration() {
		return product_duration;
	}
	/**
	 * @param product_duration the product_duration to set
	 */
	public void setProduct_duration(String product_duration) {
		this.product_duration = product_duration;
	}
	/**
	 * @return the store_name
	 */
	public String getStore_name() {
		return store_name;
	}
	/**
	 * @param store_name the store_name to set
	 */
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	/**
	 * @return the product_type_organic
	 */
	public String getProduct_type_organic() {
		return product_type_organic;
	}
	/**
	 * @param product_type_organic the product_type_organic to set
	 */
	public void setProduct_type_organic(String product_type_organic) {
		this.product_type_organic = product_type_organic;
	}
	/**
	 * @return the product_type_inorganic
	 */
	public String getProduct_type_inorganic() {
		return product_type_inorganic;
	}
	/**
	 * @param product_type_inorganic the product_type_inorganic to set
	 */
	public void setProduct_type_inorganic(String product_type_inorganic) {
		this.product_type_inorganic = product_type_inorganic;
	}
	/**
	 * @return the product_type_machines
	 */
	public String getProduct_type_machines() {
		return product_type_machines;
	}
	/**
	 * @param product_type_machines the product_type_machines to set
	 */
	public void setProduct_type_machines(String product_type_machines) {
		this.product_type_machines = product_type_machines;
	}
	/**
	 * @return the product_seeds
	 */
	public String getProduct_seeds() {
		return product_seeds;
	}
	/**
	 * @param product_seeds the product_seeds to set
	 */
	public void setProduct_seeds(String product_seeds) {
		this.product_seeds = product_seeds;
	}
	/**
	 * @return the product_medicine
	 */
	public String getProduct_medicine() {
		return product_medicine;
	}
	/**
	 * @param product_medicine the product_medicine to set
	 */
	public void setProduct_medicine(String product_medicine) {
		this.product_medicine = product_medicine;
	}
	/**
	 * @return the product_fertizer
	 */
	public String getProduct_fertizer() {
		return product_fertizer;
	}
	/**
	 * @param product_fertizer the product_fertizer to set
	 */
	public void setProduct_fertizer(String product_fertizer) {
		this.product_fertizer = product_fertizer;
	}
	
	
	
	
}
