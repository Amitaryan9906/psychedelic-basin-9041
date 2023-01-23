package com.useCases;

import java.util.Scanner;

import com.BeanClasses.Vendor;
import com.DAO.AdministratorDAO;
import com.DAO.AdministratorDaoImpl;

public class VendorRegistration {

	public static void registerVendor() {
    Scanner sc=new Scanner(System.in);
    
    AdministratorDAO vd=new AdministratorDaoImpl();
    
    System.out.println("Enter Id");
    String vId=sc.next();
    
    System.out.println("Enter Name");
    String vName=sc.next();
    
    System.out.println("Enter mobile number");
    String vMobile=sc.next();
    
    System.out.println("Enter Email");
    String vEmail=sc.next();
    
    System.out.println("Enter Address");
    String vAddress=sc.next();
    
    System.out.println("Enter Company");
    String vCompany=sc.next();
    
    System.out.println("Enter Password");
    String vPassword=sc.next();
    
    
    sc.close();
    
    Vendor v=new Vendor();
    
    v.setId(vId);
    v.setName(vName);
    v.setMobile(vMobile);
    v.setEmail(vEmail);
    v.setPassword(vPassword);
    v.setAddress(vAddress);
    v.setCompany(vCompany);
    
    
    String message=vd.registerVendor(v);
	}

}
