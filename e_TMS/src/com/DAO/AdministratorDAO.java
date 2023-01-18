package com.DAO;

import java.util.List;

public interface AdministratorDAO {
public String admLogin(String admUserName,String admPassword);
public String registerVendor(String VUserName,String vPassword);
public List<Vender> getAllVender();
 
}
