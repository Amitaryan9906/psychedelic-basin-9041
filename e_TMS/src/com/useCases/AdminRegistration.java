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
            String message = aDao.admLogin(email, password,adm.getName());
            System.out.println(message);
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
