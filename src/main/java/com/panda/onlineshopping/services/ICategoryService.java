package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.ProductCategory;

public interface ICategoryService {

	public ProductCategory getProductCategoryById(int categoryId);

	public void createProductCategory(ProductCategory category);

	public ProductCategory updateProductCategory(ProductCategory category);

	public void deleteProductCategory(ProductCategory category);

	public List<ProductCategory> getAllProductCategories();
}
