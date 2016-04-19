package com.panda.onlineshopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.panda.onlineshopping.entities.ProductCategory;
import com.panda.onlineshopping.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<ProductCategory> createCategory(@RequestBody ProductCategory category) {
		categoryService.createProductCategory(category);
		return new ResponseEntity<ProductCategory>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "get/{catId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductCategory> getCategoryById(@PathVariable int catId) {
		ProductCategory category = categoryService.getProductCategoryById(catId);
		if (category == null) {
			return new ResponseEntity<ProductCategory>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProductCategory>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "get/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductCategory>> getAllCategoies() {
		List<ProductCategory> categories = categoryService.getAllProductCategories();
		if (categories.isEmpty()) {
			return new ResponseEntity<List<ProductCategory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProductCategory>>(categories, HttpStatus.OK);
	}

	@RequestMapping(value = "edit/{catId}", method = RequestMethod.PUT)
	public ResponseEntity<ProductCategory> editCategory(@PathVariable("catId") int catId,
			@RequestBody ProductCategory category) {

		ProductCategory currentCat = categoryService.getProductCategoryById(catId);
		if (currentCat == null)
			return new ResponseEntity<ProductCategory>(HttpStatus.NOT_FOUND);

		currentCat = category;
		currentCat.setCategoryId(catId);
		categoryService.updateProductCategory(currentCat);
		return new ResponseEntity<ProductCategory>(currentCat, HttpStatus.OK);
	}
}
