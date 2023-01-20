package com.DAO;

import java.util.List;

import com.BeanClasses.Tender;
import com.BeanClasses.Vendor;

public interface AdministratorDAO{
	
      public String admLogin(String admUserName,String admPassword);
      public String registerVendor(String VUserName,String vPassword);
      public List<Vendor> getAllVendor();
      public String createTender(Tender t);
      public boolean removeTender(Tender t);
      public String updateTender(Tender tender);
	  public List<Tender> getAllTenders();
	  public String assignTenderToVendor(String tenderId,String vendorId,String bidderId);
//	  public String getTenderStatus(String tenderId);

}
