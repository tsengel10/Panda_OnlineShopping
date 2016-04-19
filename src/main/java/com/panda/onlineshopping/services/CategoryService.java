package com.panda.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.CategoryDao;
import com.panda.onlineshopping.entities.ProductCategory;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public ProductCategory getProductCategoryById(int categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}

	@Override
	public void createProductCategory(ProductCategory category) {
		categoryDao.createCategory(category);

	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public void deleteProductCategory(ProductCategory category) {
		categoryDao.deleteCategory(category);
	}

	@Override
	public List<ProductCategory> getAllProductCategories() {
		return categoryDao.getAllCategories();
	}

}
