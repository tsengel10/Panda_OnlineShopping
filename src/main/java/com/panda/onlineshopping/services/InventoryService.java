package com.panda.onlineshopping.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panda.onlineshopping.dao.InventoryDao;
import com.panda.onlineshopping.entities.Inventory;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public int createInventory(Inventory inventory) {
		return inventoryDao.createInventory(inventory);
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return inventoryDao.updateInventory(inventory);
	}

	@Override
	public List<Inventory> getInventoryByVendorId(int vendorId) {
		return inventoryDao.getInventoriesByVendorId(vendorId);
	}

	@Override
	public List<Inventory> getInventoryByProductId(int productId) {
		return inventoryDao.getInventoriesByProductId(productId);
	}

	@Override
	public Inventory getInventoryById(int id) {
		return inventoryDao.getInventoryById(id);
	}
}