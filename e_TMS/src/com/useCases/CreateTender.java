package com.useCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.BeanClasses.Tender;
import com.DAO.AdministratorDAO;
import com.DAO.AdministratorDaoImpl;

public class CreateTender {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Tender Id");
        String tId = sc.next();
        System.out.println("Enter Tender Name");
        String tName = sc.next();
        System.out.println("Enter Tender Type");
        String tType = sc.next();
        System.out.println("Enter Tender Price");
        int tPrice = sc.nextInt();
        System.out.println("Enter Tender Description");
        String tDesc = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter Tender Deadline");
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String dateString = sc.nextLine();
        LocalDate deadline = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            deadline = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format, please enter the date in YYYY-MM-DD format");
            e.printStackTrace();
        }

        System.out.println("Enter Location");
        String tLocation = sc.next();
        AdministratorDAO aDao = new AdministratorDaoImpl();
        Tender t = new Tender(tId, tName, tType, tPrice, tDesc, deadline, tLocation);
        aDao.createTender(t);
    }
}
