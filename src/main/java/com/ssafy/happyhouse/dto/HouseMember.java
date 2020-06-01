package com.ssafy.happyhouse.dto;

public class HouseMember {
	private String id; // PK
	private String password;
	private String name;
	private String address;
	private String phone;

	public HouseMember() {}
	
	public HouseMember(String id, String password, String name, String address, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "HouseMember [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
