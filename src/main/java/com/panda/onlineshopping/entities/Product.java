package com.panda.onlineshopping.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private int productId;
	@Column
	private String productName;
	@Column
	private String productDescription;
	@Column
	private String productCreatedDate;
	@Column
	private String productUpdatedDate;
	@Column
	private String field_1;
	@Column
	private String field_2;
	@Column
	private String field_3;
	@Column
	private String field_4;
	@Column
	private String field_5;
	@Column
	private String field_6;
	@Column
	private String field_7;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	protected Set<Inventory> inventories = new HashSet<>();

	public Product() {

	}

	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(String productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}

	public String getProductUpdated() {
		return productUpdatedDate;
	}

	public void setProductUpdatedDate(String productUpdatedDate) {
		this.productUpdatedDate = productUpdatedDate;
	}

	public String getField_1() {
		return field_1;
	}

	public void setField_1(String field_1) {
		this.field_1 = field_1;
	}

	public String getField_2() {
		return field_2;
	}

	public void setField_2(String field_2) {
		this.field_2 = field_2;
	}

	public String getField_3() {
		return field_3;
	}

	public void setField_3(String field_3) {
		this.field_3 = field_3;
	}

	public String getField_4() {
		return field_4;
	}

	public void setField_4(String field_4) {
		this.field_4 = field_4;
	}

	public String getField_5() {
		return field_5;
	}

	public void setField_5(String field_5) {
		this.field_5 = field_5;
	}

	public String getField_6() {
		return field_6;
	}

	public void setField_6(String field_6) {
		this.field_6 = field_6;
	}

	public String getField_7() {
		return field_7;
	}

	public void setField_7(String field_7) {
		this.field_7 = field_7;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productCreatedDate=" + productCreatedDate + ", productUpdatedDate="
				+ productUpdatedDate + ", field_1=" + field_1 + ", field_2=" + field_2 + ", field_3=" + field_3
				+ ", field_4=" + field_4 + ", field_5=" + field_5 + ", field_6=" + field_6 + ", field_7=" + field_7
				+ ", inventories=" + inventories + "]";
	}

}
