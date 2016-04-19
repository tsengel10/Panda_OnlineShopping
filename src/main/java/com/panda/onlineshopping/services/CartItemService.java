package com.panda.onlineshopping.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.CartItemDao;
import com.panda.onlineshopping.entities.CartItem;

@Service
public class CartItemService implements ICartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public CartItem create(int userId, int inventoryId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem updateQuantity(int cartItemId, int quantity) {
		CartItem cartItem = cartItemDao.getById(cartItemId);
		cartItem.setQuantity(quantity);
		return cartItemDao.update(cartItem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject delete(int cartItemId) {
		JSONObject ob = new JSONObject();
		if (cartItemDao.getById(cartItemId) == null) {
			ob.put("status", "fail");
			ob.put("detail", "Can not find the cart item to delete.");
		} else {
			cartItemDao.delete(cartItemId);
			ob.put("status", "success");
		}
		return ob;
	}

}
