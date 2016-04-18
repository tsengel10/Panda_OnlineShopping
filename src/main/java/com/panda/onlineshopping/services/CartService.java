package com.panda.onlineshopping.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.CartDao;
import com.panda.onlineshopping.dao.CartItemDao;
import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.entities.CartItem;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public Cart getByUserId(int userId) {
		return cartDao.getByUserId(userId);
	}

	@Override
	public void create(Cart cart) {
		cartDao.create(cart);
	}

	@Override
	public Cart update(Cart cart) {
		return cartDao.update(cart);
	}

	@Override
	public void delete(Cart cart) {
		cartDao.delete(cart);
	}

	@Override
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

	@Override
	public CartItem addItem(int userId, int inventoryId, int quantity) {

		Cart currentCart = cartDao.getByUserId(userId);
		Set<CartItem> currentCartItems = currentCart.getCartItems();
		int newQuantity = 0;
		boolean exists = false;
		for (CartItem currentCartItem : currentCartItems) {
			if (currentCartItem.getInventoryId() == inventoryId) {
				cartItemDao.delete(currentCartItem);
				newQuantity = quantity + currentCartItem.getQuantity();
				exists = true;
			}
		}


		Cart cart = cartDao.getByUserId(userId);
		CartItem newItem = new CartItem();
		newItem.setCart(cart);
		newItem.setInventoryId(inventoryId);

		if (exists) {
			newItem.setQuantity(newQuantity);
			cartItemDao.create(newItem);
		} else {
			newItem.setQuantity(quantity);
			cartItemDao.create(newItem);
		}
		return newItem;
	}

}
