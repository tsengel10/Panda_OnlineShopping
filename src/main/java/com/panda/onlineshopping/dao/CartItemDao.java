package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.CartItem;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class CartItemDao implements ICartItemDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void create(CartItem cartItem) {
		hibernateUtil.create(cartItem);
	}

	@Override
	public CartItem update(CartItem cartItem) {
		return hibernateUtil.update(cartItem);
	}

	@Override
	public void delete(CartItem cartItem) {
		hibernateUtil.delete(cartItem);
	}

	@Override
	public List<CartItem> getAll() {
		return hibernateUtil.fetchAll(CartItem.class);
	}

	@Override
	public CartItem getById(int id) {
		return hibernateUtil.fetchById(id, CartItem.class);
	}
}
