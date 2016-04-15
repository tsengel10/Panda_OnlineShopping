package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Cart;

public interface ICartService {

	public Cart getByUserId(int id);

	public void create(Cart cart);

	public Cart update(Cart cart);

	public void delete(Cart cart);

	public List<Cart> getAll();

}
