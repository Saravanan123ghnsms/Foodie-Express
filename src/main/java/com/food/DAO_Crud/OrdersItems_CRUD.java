package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAOInterface.OrdersItemsDAO;
import com.food.modelclass.OrdersItemsPojo;

public class OrdersItems_CRUD implements OrdersItemsDAO {
	private String insert_query="insert into orderitems(orderid,menuid,quantity,subtotal)"
			+ "values(?,?,?,?)";
	private String fetch_query="select * from orderitems where orderid=?";
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
	public int insertOrderItems(OrdersItemsPojo obj) {
		int res=0;
	   try {
		psmt=con.prepareStatement(insert_query);
		psmt.setInt(1, obj.getOrderid());
		psmt.setInt(2,obj.getMenuid());
		psmt.setInt(3,obj.getQuantity());
		psmt.setFloat(4,obj.getSubtotal());
		res=psmt.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   finally {
		try {
			psmt.close();
		} catch (Exception e2) {
			// TODO: handle 
           e2.printStackTrace();
		}
	}
	   return res;
	}

	@Override
	public List<OrdersItemsPojo> fetchOrdersItems(int orderid) {
		List<OrdersItemsPojo> list = new ArrayList<OrdersItemsPojo>();
		OrdersItemsPojo result=null;
		  try {
			psmt=con.prepareStatement(fetch_query);
			psmt.setInt(1, orderid);
			rs=psmt.executeQuery();
			while(rs.next())
			{
			result=new OrdersItemsPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
			list.add(result);
			result=null;
			}
			
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
		 return list; 
	}

}
