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

import com.panda.onlineshopping.entities.Inventory;
import com.panda.onlineshopping.entities.InventoryPicture;
import com.panda.onlineshopping.services.InventoryPictureService;
import com.panda.onlineshopping.services.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private InventoryPictureService inventoryPictureService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		int invId = inventoryService.createInventory(inventory);
		if (!inventory.getPictures().isEmpty()) {
			for (InventoryPicture pic : inventory.getPictures()) {
				pic.setInventoryId(invId);
				inventoryPictureService.createInventoryPicture(pic);
			}
		}
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}

	@RequestMapping(value = "get/{invId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> getInventoryById(@PathVariable int invId) {
		Inventory inventory = inventoryService.getInventoryById(invId);
		if (inventory == null) {
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
	}

	@RequestMapping(value = "get/vendor/{vendorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Inventory>> getInventoriesByVendorId(@PathVariable int vendorId) {
		List<Inventory> inventories = inventoryService.getInventoryByVendorId(vendorId);
		if (inventories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
	}

	@RequestMapping(value = "get/product/{prodId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Inventory>> getInventoriesByProductId(@PathVariable int prodId) {
		List<Inventory> inventories = inventoryService.getInventoryByProductId(prodId);
		if (inventories.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
	}

	@RequestMapping(value = "edit/{invId}", method = RequestMethod.PUT)
	public ResponseEntity<Inventory> editProduct(@PathVariable("invId") int invId, @RequestBody Inventory inventory) {

		Inventory currentInv = inventoryService.getInventoryById(invId);
		if (currentInv == null)
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		currentInv = inventory;
		currentInv.setInventoryId(invId);
		inventoryService.updateInventory(currentInv);
		return new ResponseEntity<Inventory>(currentInv, HttpStatus.OK);
	}
}
