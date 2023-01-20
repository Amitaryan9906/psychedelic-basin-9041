package com.DAO;

import java.util.List;

import com.BeanClasses.Tender;
import com.BeanClasses.Vendor;

public class AdministratorDaoImpl implements AdministratorDAO{

	@Override
	public String admLogin(String admUserName, String admPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerVendor(String VUserName, String vPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getAllVendor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createTender(Tender t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeTender(Tender t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateTender(Tender tender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tender> getAllTenders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignTenderToVendor(String tenderId, String vendorId, String bidderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
