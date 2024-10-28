package com.food.modelclass;

public class UserPojo {
    int userid;
	String user_name, password, email, address;
	long phonenumber;

	public UserPojo(String user_name, String password, String email, long phonenumber, String address) {
		super();

		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phonenumber = phonenumber;
	}

	public UserPojo() {
		super();
	}
   
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "UserPojo Information [user_name=" + user_name + ", password=" + password + ", email=" + email + ", address="
				+ address + ", phonenumber=" + phonenumber + "]";
	}

	

}
