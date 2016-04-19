package com.panda.onlineshopping.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Inventory;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class InventoryDao implements IInventoryDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public int createInventory(Inventory inventory) {
		return (int) hibernateUtil.create(inventory);
	}

	@Override
	public Inventory updateInventory(Inventory inventory) {
		return hibernateUtil.update(inventory);
	}

	@Override
	public List<Inventory> getInventoriesByVendorId(int vendorId) {
		String query = "from Inventory where vendorId = " + vendorId;
		List<Inventory> dbInventories = hibernateUtil.runSelectQueryList(query);
		return dbInventories;
	}

	@Override
	public List<Inventory> getInventoriesByProductId(int productId) {
		String query = "from Inventory where productId = " + productId;
		List<Inventory> dbInventories = hibernateUtil.runSelectQueryList(query);
		return dbInventories;
	}

	@Override
	public Inventory getInventoryById(int id) {
		return hibernateUtil.fetchById(id, Inventory.class);
	}

}
