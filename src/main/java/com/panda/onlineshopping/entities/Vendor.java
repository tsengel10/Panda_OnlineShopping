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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	int vendorid;
	@Column
	private String vendorName;
	@Column
	private String vendorCode;
	@Column
	private String phone;
	@Column
	private String image_link;

	public Vendor() {

	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", vendorName=" + vendorName + ", vendorCode=" + vendorCode + ", phone="
				+ phone + ", image_link=" + image_link + ", userid=" + userid + ", username=" + username + ", password="
				+ password + ", usertype=" + usertype + ", addresses=" + addresses + "]";
	}

}
