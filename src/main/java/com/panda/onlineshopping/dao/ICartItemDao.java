package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.CartItem;

public interface ICartItemDao {

	public void create(CartItem cartItem);

	public CartItem update(CartItem cartItem);

	public void delete(CartItem cartItem);

	public List<CartItem> getAll();

	public CartItem getById(int id);

}
