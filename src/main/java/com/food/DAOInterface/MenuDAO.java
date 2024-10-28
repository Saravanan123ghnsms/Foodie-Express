package com.food.DAOInterface;

import java.util.List;

import com.food.modelclass.MenuPojo;

public interface MenuDAO {
     int insertmenu(MenuPojo e);
     List<MenuPojo> getMenuByRestaurantId(int restaurantId);
     MenuPojo getMenubyMenuId(int menuid);
     int deleteMenubyId(int menuid);
     int updateMenubyId(int id,boolean isActive);
     
     
}
