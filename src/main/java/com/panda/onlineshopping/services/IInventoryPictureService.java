package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.InventoryPicture;

public interface IInventoryPictureService {

	public void createInventoryPicture(InventoryPicture inventoryPicture);

	public InventoryPicture updateInventoryPicture(InventoryPicture inventoryPicture);

	public List<InventoryPicture> getInventoryPictureByInventoryId(int inventoryId);
}
