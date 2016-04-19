package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.ProductCategory;

public interface ICategoryDao {

	public void createCategory(ProductCategory category);

	public ProductCategory updateCategory(ProductCategory category);

	public void deleteCategory(ProductCategory category);

	public List<ProductCategory> getAllCategories();

	public ProductCategory getCategoryById(int categoryId);
}
