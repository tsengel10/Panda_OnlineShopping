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

import com.panda.onlineshopping.entities.Vendor;
import com.panda.onlineshopping.services.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
		vendorService.createVendor(vendor);
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "edit/{vendorId}", method = RequestMethod.PUT)
	public ResponseEntity<Vendor> editVendor(@PathVariable("vendorId") int vendorId, @RequestBody Vendor vendor) {

		Vendor currentVendor = vendorService.getVendorById(vendorId);
		if (currentVendor == null)
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);

		currentVendor = vendor;
		currentVendor.setUserid(vendorId);
		vendorService.updateVendor(currentVendor);
		return new ResponseEntity<Vendor>(currentVendor, HttpStatus.OK);
	}

	@RequestMapping(value = "get/{vendorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendor> getVendorById(@PathVariable("vendorId") int vendorId) {
		Vendor vendor = vendorService.getVendorById(vendorId);
		if (vendor == null) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}

}
