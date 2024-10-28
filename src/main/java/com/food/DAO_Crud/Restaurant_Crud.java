package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAOInterface.RestaurantDAO;
import com.food.modelclass.RestaurantPojo;

public class Restaurant_Crud implements RestaurantDAO {
	private String insertquery = "insert into restaurant(restaurant_id,restaurantname,cuisinetype,deliverytime,isActive,rating,imagepath)"
			+ "values(?,?,?,?,?,?,?)";
	private String fetchAll = "select * from restaurant";
	private String fetchSpecific = "select * from restaurant where restaurant_id=?";
	private String updatequery = "update restaurant set isActive=? where restaurant_id=?";
	private String deletequery = "delete from restaurant where restaurant_id=?";

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
	public int insertRestaurant(RestaurantPojo r) {
		int res = 0;

		try {
			psmt = con.prepareStatement(insertquery);
			psmt.setInt(1, r.getRestaurantid());
			psmt.setString(2, r.getRestaurantname());
			psmt.setString(3, r.getCuisinetype());
			psmt.setInt(4, r.getDeliverytime());
			psmt.setBoolean(5, r.isActive());
			psmt.setInt(6, r.getRating());
			psmt.setString(7, r.getImagepath());
			res = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;

	}

	@Override
	public List<RestaurantPojo> getAllRestaurant() {
		// TODO Auto-generated method stub
		ArrayList<RestaurantPojo> result = new ArrayList<RestaurantPojo>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(fetchAll);
			while (rs.next()) {
				RestaurantPojo temp = new RestaurantPojo();
				temp.setRestaurantid(rs.getInt(1));
				temp.setRestaurantname(rs.getString(2));
				temp.setCuisinetype(rs.getString(3));
				temp.setDeliverytime(rs.getInt(4));
				temp.setActive(rs.getBoolean(5));
				temp.setRating(rs.getInt(6));
				temp.setImagepath(rs.getString(7));
				result.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
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
	public RestaurantPojo getRestById(int rest_id) {
		// TODO Auto-generated method stub
		RestaurantPojo temp = null;
		try {
			psmt = con.prepareStatement(fetchSpecific);
			psmt.setInt(1, rest_id);
			rs = psmt.executeQuery();
			rs.next();
			temp = new RestaurantPojo();
			//temp.setRestaurant_id(rs.getInt(1));
			temp.setRestaurantname(rs.getString(2));
			temp.setCuisinetype(rs.getString(3));
			temp.setDeliverytime(rs.getInt(4));
			temp.setActive(rs.getBoolean(5));
			temp.setRating(rs.getInt(6));
			temp.setImagepath(rs.getString(7));
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
		return temp;

	}

	@Override
	public int deleteRestById(int rest_id) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			psmt = con.prepareStatement(deletequery);
			psmt.setInt(1, rest_id);
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
	public int updateRestById(int id, boolean isActive) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			psmt = con.prepareStatement(updatequery);
			psmt.setInt(2, id);
			psmt.setBoolean(1, isActive);
			res = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return res;
	}


}
