package com.panda.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.panda.onlineshopping.dao.CartDao;
import com.panda.onlineshopping.entities.Cart;

public class CartService implements ICartService {
	@Autowired
	private CartDao cartDao;

	@Override
	public Cart getByUserId(int id) {
		return cartDao.getByUserId(id);
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

}
