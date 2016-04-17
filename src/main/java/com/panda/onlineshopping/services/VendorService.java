package com.panda.onlineshopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.VendorDao;
import com.panda.onlineshopping.entities.Vendor;

@Service
public class VendorService implements IVendorService {

	@Autowired
	private VendorDao vendorDao;

	@Override
	public void createVendor(Vendor vendor) {
		vendorDao.createVendor(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return vendorDao.updateVendor(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		vendorDao.deleteVendor(vendor);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return vendorDao.getAllVendors();
	}

	@Override
	public Vendor getVendorById(int vendorId) {
		return vendorDao.getVendorById(vendorId);
	}

}
