package com.MainClass;

import java.util.Scanner;

import com.useCases.AdminRegistration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to e-Tender");
        System.out.println("Press 1 for Administrator LogIn");
        System.out.println("Press 2 for Vendor LogIn");
        System.out.println("Press 3 for Exit");
        while (true) {
            try {
                int n = sc.nextInt();
                if (n == 1) {
                    AdminRegistration admReg = new AdminRegistration();
                    admReg.adminReg();
                    break;
                } else if (n == 2) {
                    System.out.println("Coming soon");
                    
                    break;
                } else if(n==3){
                    return;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input, please enter a valid option.");
            }
        }

	}

}
