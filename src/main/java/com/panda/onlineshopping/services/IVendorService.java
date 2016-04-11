package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.Vendor;

public interface IVendorService {

	public void createVendor(Vendor vendor);

	public Vendor updateVendor(Vendor vendor);

	public void deleteVendor(Vendor vendor);

	public List<Vendor> getAllVendors();

	public Vendor getVendorById(int vendorId);

}