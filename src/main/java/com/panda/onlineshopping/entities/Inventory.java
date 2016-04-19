package com.panda.onlineshopping.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private int inventoryId;
	@Column
	private double price;
	@Column
	private int quantity;
	@Column
	private boolean enabled;
	@Column
	private String createdDate;
	@Column
	private String updatedDate;
	@Column
	private double shippingPrice;
	@Column
	private double weight;
	@Column
	private int vendorId;
	@Column
	private int productId;
	@Column
	private int categoryId;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inventory")
	protected Set<InventoryPicture> pictures = new HashSet<>();

	public Set<InventoryPicture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<InventoryPicture> pictures) {
		this.pictures = pictures;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendorId", insertable = false, updatable = false)
	@JsonIgnore
	private Vendor vendor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	@JsonIgnore

	private ProductCategory category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	@JsonIgnore
	private Product product;

	public Inventory() {

	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", price=" + price + ", quantity=" + quantity + ", enabled="
				+ enabled + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", shippingPrice="
				+ shippingPrice + ", weight=" + weight + ", vendorId=" + vendorId + ", productId=" + productId
				+ ", categoryId=" + categoryId + ", pictures=" + pictures + "]";
	}

}
