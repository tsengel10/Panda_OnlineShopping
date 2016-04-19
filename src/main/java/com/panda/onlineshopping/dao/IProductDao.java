package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.Product;

public interface IProductDao {

	public void createProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(int productId);
}
