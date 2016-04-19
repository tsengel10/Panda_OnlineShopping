package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.ProductCategory;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class CategoryDao implements ICategoryDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createCategory(ProductCategory category) {
		hibernateUtil.create(category);
	}

	@Override
	public ProductCategory updateCategory(ProductCategory category) {
		return hibernateUtil.update(category);
	}

	@Override
	public void deleteCategory(ProductCategory category) {
		hibernateUtil.delete(category);
	}

	@Override
	public List<ProductCategory> getAllCategories() {
		return hibernateUtil.fetchAll(ProductCategory.class);
	}

	@Override
	public ProductCategory getCategoryById(int categoryId) {
		return hibernateUtil.fetchById(categoryId, ProductCategory.class);
	}

}
