package com.panda.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	int addressid;
	@Column
	String address1;
	@Column
	String address2;
	@Column
	String city;
	@Column
	String state;
	@Column
	String zip;
	@Column
	String type;
	
	public Address(){}
	
	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid +", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip +", type=" + type +"]";
	}
	
}

