package com.panda.onlineshopping.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@PrimaryKeyJoinColumn(name = "user_id")
public class Cart extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	private Set<CartItem> cartItems;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + ", userid=" + userid + "]";
	}

}
