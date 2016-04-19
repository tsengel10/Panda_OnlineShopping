package com.panda.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.InventoryPictureDao;
import com.panda.onlineshopping.entities.InventoryPicture;

@Service
public class InventoryPictureService implements IInventoryPictureService {

	@Autowired
	private InventoryPictureDao inventoryPictureDao;

	@Override
	public void createInventoryPicture(InventoryPicture inventoryPicture) {
		inventoryPictureDao.createInventoryPicture(inventoryPicture);
	}

	@Override
	public InventoryPicture updateInventoryPicture(InventoryPicture inventoryPicture) {
		return inventoryPictureDao.updateInventoryPicture(inventoryPicture);
	}

	@Override
	public List<InventoryPicture> getInventoryPictureByInventoryId(int inventoryId) {
		return inventoryPictureDao.getInventoryPictureByInventoryId(inventoryId);
	}

}
