package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.Inventory;

public interface IInventoryDao {

	public int createInventory(Inventory inventory);

	public Inventory updateInventory(Inventory inventory);

	public Inventory getInventoryById(int id);

	public List<Inventory> getInventoriesByVendorId(int vendorId);

	public List<Inventory> getInventoriesByProductId(int productId);

}
