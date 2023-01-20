package com.useCases;

import java.util.List;

import com.BeanClasses.Vendor;
import com.DAO.AdministratorDAO;
import com.DAO.AdministratorDaoImpl;
import com.Exception.VendorException;

public class GetVendors {
public static void main(String[] args) throws VendorException {
	AdministratorDAO ps = new AdministratorDaoImpl();
	
	List<Vendor> vendors = ps.getAllVendor();
	
	vendors.forEach(v -> System.out.println(v));
}
}
