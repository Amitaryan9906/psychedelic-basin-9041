package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClasses.Tender;
import com.Utility.DButil;

public class VendorDaoImpl implements VendorDAO {

	@Override
	public String venderLogin(String vUserName, String VPassword) {
	    try (Connection con=DButil.provideConnection()){

	        // Check if the given username and password match a vendor in the database
	        String loginSql = "SELECT * FROM Vendor WHERE username = ? AND password = ?";
	        PreparedStatement loginStmt = con.prepareStatement(loginSql);
	        loginStmt.setString(1, vUserName);
	        loginStmt.setString(2, VPassword);
	        ResultSet result = loginStmt.executeQuery();

	        // Return success message if a match is found
	        if(result.next()) {
	            return "Vendor successfully logged in";
	        } else {
	            return "Invalid username or password";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Error occurred while logging in";
	    }
	}

	@Override
	public List<Tender> viewCurrentTenders(Tender t) {
		
	    List<Tender> tenders = new ArrayList<>();
	    try (Connection con=DButil.provideConnection()){
	        // Retrieve all current tenders from the database
	        String selectTendersSql = "SELECT * FROM Tenders WHERE status = 'open'";
	        PreparedStatement selectTendersStmt = con.prepareStatement(selectTendersSql);
	        ResultSet result = selectTendersStmt.executeQuery();

	        // Create a list to store the tenders
	        

	        // Add each tender to the list
	        while(result.next()) {
	            Tender tender = new Tender();
	            tender.setId(result.getString("id"));
	            tender.setName(result.getString("name"));
	            tender.setType(result.getString("type"));
	            tender.setPrice(result.getInt("price"));
	            tender.setDesc(result.getString("descr"));
	            tender.getDeadline(result.getString("deadline"));
	            tender.setLocation(result.getString("location"));
	            tenders.add(tender);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

      return tenders;
  }
}