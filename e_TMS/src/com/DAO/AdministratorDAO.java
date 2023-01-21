package com.DAO;

import java.util.List;

import com.BeanClasses.Tender;
import com.BeanClasses.Vendor;

public interface AdministratorDAO{
	  public boolean isAdminExist(String email);
	  public String registerAdmin(String id, String name, String email, String password, String mobile);
      public String admLogin(String admUserName,String admPassword,String name);
      public String registerVendor(Vendor vendor);
      public List<Vendor> getAllVendor();
      public String createTender(Tender t);
      public boolean removeTender(Tender t);
      public String updateTender(Tender tender);
	  public List<Tender> getAllTenders();
	  public String assignTenderToVendor(String tenderId,String vendorId,String bidderId);
//	  public String getTenderStatus(String tenderId);

}
