package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.entities.CartItem;

public interface ICartService {

	public Cart getByUserId(int id);

	public void create(Cart cart);

	public Cart update(Cart cart);

	public void delete(Cart cart);

	public List<Cart> getAll();

	CartItem addItem(int userId, int cartItemId, int quantity);

}
