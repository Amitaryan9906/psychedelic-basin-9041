package com.DAO;

import java.util.List;

import com.BeanClasses.Tender;

public interface VendorDAO {

	public String venderLogin(String vUserName,String VPassword);
	public List<Tender> viewCurrentTenders(Tender t);
	
	
}
