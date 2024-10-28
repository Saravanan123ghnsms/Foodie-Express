package com.food.DAO_Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAOInterface.MenuDAO;
import com.food.modelclass.MenuPojo;

public class Menu_Crud implements MenuDAO {
	private String insertquery = "insert into menu(restaurant_id,itemname,description,price,isActive,imagepath)"
			+ "values(?,?,?,?,?,?)";
	private String selectallquery = "select * from menu";
	private String fetchbymenuid = "select * from menu where menuid=?";
	private String fetchbyrestaurantid = "select * from menu where restaurant_id=?";
	private String deletemenuid = "delete from menu where menu_id=?";
	private String updatemenuid = "update menu set isActive=? where menuid=?";
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
	public int insertmenu(MenuPojo e) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			psmt = con.prepareStatement(insertquery);
			
			psmt.setInt(1, e.getRestaurant_id());
			psmt.setString(2, e.getItemname());
			psmt.setString(3, e.getDescription());
			psmt.setFloat(4, e.getPrice());
			psmt.setBoolean(5, e.getIsActive());
			psmt.setString(6, e.getImagepath());
			res = psmt.executeUpdate();

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
		return res;
	}

	@Override
	public List<MenuPojo> getMenuByRestaurantId(int restaurantId) {
		List<MenuPojo> result = new ArrayList<MenuPojo>();
		try {
			psmt = con.prepareStatement(fetchbyrestaurantid);
			psmt.setInt(1, restaurantId);
			rs = psmt.executeQuery();
			MenuPojo temp = new MenuPojo();
			while (rs.next()) {
				temp.setMenuid(rs.getInt(1));
				temp.setRestaurant_id(rs.getInt(2));
				temp.setItemname(rs.getString(3));
				temp.setDescription(rs.getString(4));
				temp.setPrice(rs.getFloat(5));
				temp.setIsActive(rs.getBoolean(6));
				temp.setImagepath(rs.getString(7));
				result.add(temp);
				temp=new MenuPojo();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public MenuPojo getMenubyMenuId(int menuid) {
		MenuPojo res = new MenuPojo();
		try {
			psmt = con.prepareStatement(fetchbymenuid);
			psmt.setInt(1, menuid);
			rs = psmt.executeQuery();
			rs.next();
	     	res.setMenuid(rs.getInt(1));
			res.setRestaurant_id(rs.getInt(2));
			res.setItemname(rs.getString(3));
			res.setDescription(rs.getString(4));
			res.setPrice(rs.getFloat(5));
			res.setIsActive(rs.getBoolean(6));
			res.setImagepath(rs.getString(7));

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
		return res;
	}

	@Override
	public int deleteMenubyId(int menuid) {
		int res = 0;
		try {
			psmt = con.prepareStatement(deletemenuid);
			psmt.setInt(1, menuid);
			res = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public int updateMenubyId(int id, boolean isActive) {
		int res = 0;
		try {
			psmt = con.prepareStatement(updatemenuid);
			psmt.setBoolean(1, isActive);
			psmt.setInt(2, id);
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
