package com.webportal;

public class User {

	private String id;
	private String name_reg;
	private String shop_name_reg;
	private String address_reg;
	private String email_reg;
	private String contact_reg;
	private String password_reg;
	private String user_type;
	
	
	public User(String id, String name_reg, String shop_name_reg, String address_reg, String email_reg,
			String contact_reg, String password_reg, String user_type) {
		this.id = id;
		this.name_reg = name_reg;
		this.shop_name_reg = shop_name_reg;
		this.address_reg = address_reg;
		this.email_reg = email_reg;
		this.contact_reg = contact_reg;
		this.password_reg = password_reg;
		this.user_type = user_type;
	}
	
	public User(String name_reg, String shop_name_reg, String address_reg, String email_reg, String contact_reg,
			String password_reg, String user_type) {
		this.name_reg = name_reg;
		this.shop_name_reg = shop_name_reg;
		this.address_reg = address_reg;
		this.email_reg = email_reg;
		this.contact_reg = contact_reg;
		this.password_reg = password_reg;
		this.user_type = user_type;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getName_reg() {
		return name_reg;
	}

	public void setName_reg(String name_reg) {
		this.name_reg = name_reg;
	}

	public String getShop_name_reg() {
		return shop_name_reg;
	}

	public void setShop_name_reg(String shop_name_reg) {
		this.shop_name_reg = shop_name_reg;
	}

	public String getAddress_reg() {
		return address_reg;
	}

	public void setAddress_reg(String address_reg) {
		this.address_reg = address_reg;
	}

	public String getEmail_reg() {
		return email_reg;
	}

	public void setEmail_reg(String email_reg) {
		this.email_reg = email_reg;
	}

	public String getContact_reg() {
		return contact_reg;
	}

	public void setContact_reg(String contact_reg) {
		this.contact_reg = contact_reg;
	}

	public String getPassword_reg() {
		return password_reg;
	}

	public void setPassword_reg(String password_reg) {
		this.password_reg = password_reg;
	}

}
