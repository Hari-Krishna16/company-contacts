package de.zeroco.companycontacts.entity;

public class Company {
	private String id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String website;


	public Company(String name, String email, String phone, String address, String website) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.website = website;
	}

	
	public Company(String id, String name, String email, String phone, String address, String website) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.website = website;
	}


	public Company() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
