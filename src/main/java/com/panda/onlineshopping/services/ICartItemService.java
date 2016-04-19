package com.panda.onlineshopping.services;

import com.panda.onlineshopping.entities.CartItem;

public interface ICartItemService {

	public CartItem create(int userId, int inventoryId, int quantity);

	public CartItem updateQuantity(int cartItemId, int quantity);

	public Object delete(int cartItemId);
}
