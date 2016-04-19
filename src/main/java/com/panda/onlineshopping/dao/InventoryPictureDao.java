package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.InventoryPicture;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class InventoryPictureDao implements IInventoryPictureDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createInventoryPicture(InventoryPicture inventoryPicture) {
		hibernateUtil.create(inventoryPicture);

	}

	@Override
	public InventoryPicture updateInventoryPicture(InventoryPicture inventoryPicture) {
		return hibernateUtil.update(inventoryPicture);
	}

	@Override
	public List<InventoryPicture> getInventoryPictureByInventoryId(int inventoryId) {
		String query = "from InventoryPicture where inventoryId = " + inventoryId;
		List<InventoryPicture> dbInventoryPics = hibernateUtil.runSelectQueryList(query);
		return dbInventoryPics;
	}

}
