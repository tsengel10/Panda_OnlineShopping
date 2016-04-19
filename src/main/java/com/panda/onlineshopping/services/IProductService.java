package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Product;

public interface IProductService {

	public Product getProductById(int productId);

	public void createProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> getAllProducts();
}
