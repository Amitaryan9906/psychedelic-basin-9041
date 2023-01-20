package com.BeanClasses;

public class Administrator {

	String Id;
	String name;
	String email;
	String password;
	String mobile;
	public Administrator() {};
	public Administrator(String id, String name, String email, String password, String mobile) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Administrator [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + "]";
	}
	
}
