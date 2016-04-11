package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Vendor;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class VendorDao implements IVendorDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createVendor(Vendor vendor) {

		System.out.println("======= Im vendor");
		System.out.println(vendor);
		hibernateUtil.create(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return hibernateUtil.update(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		hibernateUtil.delete(vendor);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return hibernateUtil.fetchAll(Vendor.class);
	}

	@Override
	public Vendor getVendor(int vendorId) {
		return hibernateUtil.fetchById(vendorId, Vendor.class);
	}

}
