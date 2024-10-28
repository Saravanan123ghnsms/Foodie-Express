package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.food.DAOInterface.UserDAO;
import com.food.modelclass.UserPojo;

public class UserCrud implements UserDAO {

	private String insertquery = "insert into user(user_name,password,email,address,phonenumber)"
			+ "values(?,?,?,?,?);";
	private String fetchAll = "select * from user";
	private String fetchSpecific = "select * from user where user_name=?";
	private String updatePwd = "update user set password=? where user_id=?";
	private String deleteUser = "delete from user where user_id=?";
	static Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private Statement stmt;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "root", "Sara12345@#");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public int insertUser(UserPojo p) {
		int rs = 0;
		String user_name=p.getUser_name();
		String password=p.getPassword();
		String email=p.getEmail();
		String address=p.getAddress();
	    long phonenumber=p.getPhonenumber();
		try {
			psmt = con.prepareStatement(insertquery);
			psmt.setString(1, user_name);
			psmt.setString(2, password);
			psmt.setString(3, email);
			psmt.setString(4, address);
			psmt.setLong(5, phonenumber);
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return rs;

	}

	@Override
	public ArrayList<UserPojo> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<UserPojo> result = new ArrayList<>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(fetchAll);
			while (rs.next()) {
//				UserPojo temp = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3),
//						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
//				result.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;

	}

	@Override
	public UserPojo selectSpecific(String  user_name) {
		// TODO Auto-generated method stub
		UserPojo obj=null;
		try {
			psmt=con.prepareStatement(fetchSpecific);
			psmt.setString(1, user_name);
			rs=psmt.executeQuery();
		    rs.next();
		    	obj=new UserPojo();
		    	obj.setUserid(rs.getInt(1));
		    	obj.setUser_name(rs.getString(2));
		    	obj.setPassword(rs.getString(3));
		    	obj.setEmail(rs.getString(4));
		    	obj.setPhonenumber(rs.getLong(5));
		    	obj.setAddress(rs.getString(6));
		    	
		    
		    
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return obj;
	

	}

	@Override
	public void update(String password,int user_id) {
		int res=0;
		 try {
			psmt=con.prepareStatement(updatePwd);
			psmt.setString(1, password);
			psmt.setInt(2, user_id);
			res=psmt.executeUpdate();
			 if(res==1)
			 {
				 System.out.println("success");
			 }
			 else {
	           System.out.println("failure");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally
		 {
			 try {
				 psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		 }
	
	}


	@Override
	public void deleteUser(int user_id) {
	   int res=0;
		try {
			psmt=con.prepareStatement(deleteUser);
			psmt.setInt(1, user_id);
			res=psmt.executeUpdate();
			if(res==1)
			{
				System.out.println("success");
			}
			else
			{
				System.out.println("failure");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		UserPojo obj=new UserPojo("harsha", "1234","harsha@gmail.com", 4092349823l,"bangalore" );
		int res=new UserCrud().insertUser(obj);
		if(res!=0)
		{
			System.out.println("data added");
		}
		else {
			System.out.println("no added");
		}
	}
}
