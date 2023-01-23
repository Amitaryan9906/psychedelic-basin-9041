package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.BeanClasses.Tender;
import com.BeanClasses.Vendor;
import com.Exception.VendorException;
import com.Utility.DButil;

public class AdministratorDaoImpl implements AdministratorDAO{

	@Override
	public String admLogin(String AdmEmail, String admPassword,String adminName) {
		 String message = "Invalid username or password";
	        try (Connection con = DButil.provideConnection()) {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM administrator WHERE email = ? AND password = ?");
	            ps.setString(1, AdmEmail);
	            ps.setString(2, admPassword);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                message = "Successfully logged in.";
	                adminName = rs.getString("name");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return message + " Welcome " + adminName;
		
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
      	String message="Tender not created";
      
        try (Connection con = DButil.provideConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into Tender values(?,?,?,?,?,?,?)");

            ps.setString(1, t.getId());
            ps.setString(2, t.getName());
            ps.setString(3, t.getType());
            ps.setInt(4, t.getPrice());
            ps.setString(5, t.getDesc());
            ps.setObject(6, t.getDeadline());
            ps.setString(7, t.getLocation());

            int a = ps.executeUpdate();
            if (a > 0) {
                message = "Tender created successfully";
            }
        } catch (SQLException e) {
            message = e.getMessage();
            e.printStackTrace();
        }
		
		return message;
	}

	@Override
	public  boolean removeTender(String Id) {
		 boolean res = false;
	        try (Connection con = DButil.provideConnection()) {
	            PreparedStatement ps = con.prepareStatement("DELETE FROM Tender WHERE id = ?");
	            ps.setString(1, Id);
	            int a = ps.executeUpdate();
	            if (a > 0) {
	            	res=true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return res;
	}

	@Override
	public String updateTender(Tender tender) {
		 String message = "Tender not updated";
	        try (Connection con = DButil.provideConnection()) {
	            PreparedStatement ps = con.prepareStatement("UPDATE Tender SET name = ?, type = ?, price = ?, descr = ?, deadline = ?, location = ? WHERE id = ?");
	            ps.setString(1, tender.getName());
	            ps.setString(2, tender.getType());
	            ps.setInt(3, tender.getPrice());
	            ps.setString(4, tender.getDesc());
	            ps.setDate(5, java.sql.Date.valueOf(tender.getDeadline()));
	            ps.setString(6, tender.getLocation());
	            ps.setString(7, tender.getId());
	            int a = ps.executeUpdate();
	            if (a > 0) {
	                message = "Tender updated successfully!";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return message;
	}

	@Override
	public List<Tender> getAllTenders() {
		 List<Tender> tenders = new ArrayList<>();
	        try (Connection con = DButil.provideConnection()) {
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM Tender");
	            while (rs.next()) {
	                String id = rs.getString("id");
	                String name = rs.getString("name");
	                String type = rs.getString("type");
	                int price = rs.getInt("price");
	                String desc = rs.getString("descr");
	                LocalDate deadline = rs.getDate("deadline").toLocalDate();
	                String location = rs.getString("location");
	                tenders.add(new Tender(id, name, type, price, desc, deadline, location));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return tenders;
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

	@Override
	public String registerAdmin(String id, String name, String email, String password, String mobile) {
		 String message = "Admin registration failed";

	        try (Connection con = DButil.provideConnection()) {
	            PreparedStatement ps = con.prepareStatement("INSERT INTO administrator (Id,name,email,password,mobile) VALUES (?,?,?,?,?)");
	            ps.setString(1, id);
	            ps.setString(2, name);
	            ps.setString(3, email);
	            ps.setString(4, password);
	            ps.setString(5, mobile);
	            int a = ps.executeUpdate();
	            if (a > 0) {
	                message = "Admin registered successfully";
	            }
	        } catch (SQLException e) {
	            message = e.getMessage();
	            e.printStackTrace();
	        }
	        return message;
	}

	@Override
	public boolean isAdminExist(String email) {
		  boolean isExist = false;

	        try (Connection con = DButil.provideConnection()) {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM administrator WHERE email = ?");
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                isExist = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return isExist;
	}
	

}
