package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Inventory;

public interface IInventoryService {

	public int createInventory(Inventory inventory);

	public Inventory updateInventory(Inventory inventory);

	public Inventory getInventoryById(int id);

	public List<Inventory> getInventoryByVendorId(int vendorId);

	public List<Inventory> getInventoryByProductId(int productId);
}
