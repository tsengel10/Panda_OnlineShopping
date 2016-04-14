package com.panda.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name="user_userid")
public class Customer extends User{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	int customerid;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	String email;
	@Column
	String phone;
	
	public Customer(){}
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "Customer [customerid=" + customerid +", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", userid=" + userid + ", username=" + username + ", password=" + password + ", usertype="
				+ usertype + "]";
	}
	
}
