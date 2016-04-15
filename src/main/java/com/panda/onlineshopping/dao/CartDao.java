package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.panda.onlineshopping.entities.Cart;
import com.panda.onlineshopping.utils.HibernateUtils;

public class CartDao implements ICartDao {
	
	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void create(Cart cart) {
		hibernateUtil.create(cart);
	}

	@Override
	public Cart update(Cart cart) {
		return hibernateUtil.update(cart);
	}

	@Override
	public void delete(Cart cart) {
		hibernateUtil.delete(cart);
	}

	@Override
	public List<Cart> getAll() {
		return hibernateUtil.fetchAll(Cart.class);
	}

	@Override
	public Cart getByUserId(int userId) {
		return hibernateUtil.fetchById(userId, Cart.class);
	}
}
