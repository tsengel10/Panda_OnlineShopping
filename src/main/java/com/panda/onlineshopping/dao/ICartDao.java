package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.Cart;

public interface ICartDao {
	public void create(Cart cart);

	public Cart update(Cart cart);

	public void delete(Cart cart);

	public List<Cart> getAll();

	public Cart getByUserId(int cartId);
}