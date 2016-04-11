package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.Vendor;

public interface IVendorDao {

	public void createVendor(Vendor vendor);

	public Vendor updateVendor(Vendor vendor);

	public void deleteVendor(Vendor vendor);

	public List<Vendor> getAllVendors();

	public Vendor getVendor(int vendorId);

}