package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Product;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class ProductDao implements IProductDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createProduct(Product product) {
		hibernateUtil.create(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return hibernateUtil.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		hibernateUtil.delete(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return hibernateUtil.fetchAll(Product.class);
	}

	@Override
	public Product getProductById(int productId) {
		return hibernateUtil.fetchById(productId, Product.class);
	}

}
