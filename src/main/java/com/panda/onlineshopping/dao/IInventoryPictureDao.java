package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.InventoryPicture;

public interface IInventoryPictureDao {

	public void createInventoryPicture(InventoryPicture inventoryPicture);

	public InventoryPicture updateInventoryPicture(InventoryPicture inventoryPicture);

	public List<InventoryPicture> getInventoryPictureByInventoryId(int inventoryId);
}
