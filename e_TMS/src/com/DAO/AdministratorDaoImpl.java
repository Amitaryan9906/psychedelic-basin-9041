package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BeanClasses.Tender;
import com.BeanClasses.Vendor;
import com.Exception.VendorException;
import com.Utility.DButil;

public class AdministratorDaoImpl implements AdministratorDAO{

	@Override
	public String admLogin(String admUserName, String admPassword) {
     
		
		
		return null;
	}

	@Override
	public String registerVendor(Vendor vendor) {

String status = "Registration Failed!";
	PreparedStatement ps=null;
	PreparedStatement pst=null;
		try(Connection con=DButil.provideConnection()){
				
				pst = con.prepareStatement("select * from vendor where email=?");
			
				pst.setString(1, vendor.getEmail());
				ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				
				status = "Registration Declined! "+"\n"+"Email Id already Registered";
			}
			else{
			
				
				
					ps = con.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
					
					ps.setString(1, vendor.getId());
					ps.setString(2, vendor.getName());
					ps.setString(3, vendor.getMobile());
					ps.setString(4, vendor.getEmail());
					ps.setString(5, vendor.getAddress());
					ps.setString(6, vendor.getCompany());
					ps.setString(7, vendor.getPassword());

					
					int k = ps.executeUpdate();
					
					if(k>0)
						status = "Registration Successful.Your Vendor id: "+vendor.getId()+"Thanks For Registration";
				}
				
		}
				catch(SQLException e){
					e.printStackTrace();
					status = "Error: "+e.getMessage();
				}
		
		return status;
	}

	@Override
	public String createTender(Tender t) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

	@Override
	public boolean removeTender(Tender t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateTender(Tender tender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tender> getAllTenders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignTenderToVendor(String tenderId, String vendorId, String bidderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getAllVendor() {
		// TODO Auto-generated method stub
	List<Vendor> vendors = new ArrayList<>();
		
		try(Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Vendor");			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String Id = rs.getString("Id");
				String name = rs.getString("name");
		        String mobile=rs.getNString("mobile");
		        String email=rs.getString("email");
		        String password=rs.getString("password");
		        String address=rs.getString("address");
		        String company = rs.getString("company");
				
				Vendor vendor=new Vendor(Id,name,mobile,email,password,address,company);
				
				vendors.add(vendor);
			}
			
			if(vendors.size() == 0)
				throw new VendorException("Vendors not found");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return vendors;
	}

}
