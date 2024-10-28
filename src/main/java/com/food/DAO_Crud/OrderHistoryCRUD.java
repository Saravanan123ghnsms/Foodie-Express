package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAOInterface.OrderHistoryDAO;
import com.food.modelclass.OrderHistoryPojo;

public class OrderHistoryCRUD implements OrderHistoryDAO {
	private String fetch_query = "select * from orderhistory where user_id=?";
	private String insert_query = "insert into orderhistory(user_id,orderid,totalamount)"
			+ "values(?,?,?)";
	private String update_query = "update orderhistory set status=? where historyid=?";
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
	public List<OrderHistoryPojo> fetchOrderOnUserid(int userid) {
		OrderHistoryPojo result = null;
		List<OrderHistoryPojo> list=new ArrayList<>();
		try {
			psmt = con.prepareStatement(fetch_query);
			psmt.setInt(1, userid);
			rs = psmt.executeQuery();
			while(rs.next())
			{
			result = new OrderHistoryPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
					rs.getString(6));
			list.add(result);
			result=null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insertOrderHistory(OrderHistoryPojo obj) {
		int res = 0;
		try {
			psmt = con.prepareStatement(insert_query);
			psmt.setInt(1, obj.getUser_id());
			psmt.setInt(2, obj.getOrderid());
			psmt.setFloat(3, obj.getTotalamount());
			
			res = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
	public int updateOrderHistory(int historyid, String status) {
		int res = 0;
		try {
			psmt = con.prepareStatement(update_query);
			psmt.setString(1, status);
			psmt.setInt(2, historyid);
			res = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return res;
	}

}
