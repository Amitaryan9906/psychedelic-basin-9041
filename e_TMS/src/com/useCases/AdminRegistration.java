package com.useCases;

import java.util.Scanner;

import com.BeanClasses.Administrator;
import com.DAO.AdministratorDAO;
import com.DAO.AdministratorDaoImpl;

public class AdminRegistration {

    public static void adminReg() {
        Scanner sc = new Scanner(System.in);
        AdministratorDAO aDao = new AdministratorDaoImpl();
        Administrator adm = new Administrator();
        System.out.println("Enter your email:");
        String email = sc.next();
        if (aDao.isAdminExist(email)) {
            System.out.println("Enter your password:");
            String password = sc.next();
            boolean res = aDao.admLogin(email, password,adm.getName());
            if(res==false) {
            	System.out.println("Invalid Password!\r\n"+" Enter valid Password");
            	adminReg();	
            }
            
            
            System.out.println( "Enter 1 to Register  new Vendor. (assign a new username and password to him)\r\n"
            		+ "Enter 2 to View all the vendors.\r\n"
            		+ "Enter 3 to Create new tenders.\r\n"
            		+ "Enter 4 to View All the Tenders.\r\n"
            		+ "Enter 5 to View All the Bids of a tender.\r\n"
            		+ "Enter 6 to  Assign tender to a vendor.\r\n"
            		+ "");
            while(true) {
                int c = sc.nextInt();
                try {
                    if(c < 0 || c > 6) {
                        throw new IllegalArgumentException("Invalid Input! Please enter a value between 0 and 6.");
                    }
                    if(c == 1) {
                        VendorRegistration vendorReg = new VendorRegistration();
                        vendorReg.registerVendor();
                    }
                    // Add additional actions for other valid input values (c == 2, c == 3, etc.)
                    break;
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch(Exception e) {
                    System.out.println("An error occurred. Please try again.");
                    e.printStackTrace();
                }
            }


            
        } else {
            System.out.println("Admin not found. Please register as a new administrator.");
            System.out.println("Enter Admin Id");
            String Id=sc.next();
            System.out.println("Enter your name:");
            String name = sc.next();
            System.out.println("Enter your password:");
            String password=sc.next();
            System.out.println("Enter your Email");
            String R_email=sc.next();
            System.out.println("Enter your mobile:");
            String mobile = sc.next();
            String registerMessage = aDao.registerAdmin(Id, name, R_email, password, mobile);
            System.out.println(registerMessage);
        }
    }
}
