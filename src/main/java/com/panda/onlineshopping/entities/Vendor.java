package com.panda.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
@PrimaryKeyJoinColumn(name = "user_userid")
public class Vendor extends User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	int vendorid;
	@Column
	String vendorName;
	@Column
	String vendorCode;
	@Column
	String email;
	@Column
	String phone;

	public Vendor() {

	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
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

	@Override
	public String toString() {
		return "Vendor [vendorName=" + vendorName + ", vendorCode=" + vendorCode + ", email=" + email + ", phone="
				+ phone + ", userid=" + userid + ", username=" + username + ", password=" + password + ", usertype="
				+ usertype + "]";
	}

}
