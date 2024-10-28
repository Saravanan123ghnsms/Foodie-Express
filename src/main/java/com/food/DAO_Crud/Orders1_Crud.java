package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.food.DAOInterface.Orders1DAO;
import com.food.modelclass.Orders1Pojo;

public class Orders1_Crud implements Orders1DAO{
	private String update_query="update orders1 set status=? where orderid=?";
	private String insert_query="insert into orders1(restaurant_id,totalamount,paymentoptions,user_id)"+
			 "values(?,?,?,?)";
	private String fetch_query="select * from orders1 where orderid=?";
	private String maxorderid_query="select max(orderid) from orders1;";
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
	public int updateStatus(int orderid, String status) {
		int res=0;
		// TODO Auto-generated method stub
		 try {
			psmt=con.prepareStatement(update_query);
			psmt.setString(1, status);
			psmt.setInt(2, orderid);
			res=psmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		 return res;
	}
	@Override
	public int insertOrder(Orders1Pojo e) {
		int res=0;
		try {
			psmt=con.prepareStatement(insert_query);
		
			psmt.setInt(1,e.getRestaurantid());
			psmt.setFloat(2,e.getTotalamount());
			psmt.setString(3,e.getPaymentoptions());
			psmt.setInt(4, e.getUserid());
			res=psmt.executeUpdate();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		finally {
			try {
				psmt.close();
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
		return res;
	     
	}
	@Override
	public Orders1Pojo fetchOrderDatailsByOrderid(int orderid) {
		 Orders1Pojo temp = null;
		 try {
			psmt=con.prepareStatement(fetch_query);
			psmt.setInt(1, orderid);
			rs=psmt.executeQuery();
			rs.next();
			temp=new Orders1Pojo(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally {
			try {
				rs.close();
				psmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		 return temp;
	}
	public int maxorderId()
	{
		int result =0 ;
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(maxorderid_query);
			rs.next();
			result=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
