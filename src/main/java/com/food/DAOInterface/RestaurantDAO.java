package com.food.DAOInterface;

import java.util.List;

import com.food.modelclass.RestaurantPojo;

public interface RestaurantDAO {
      int insertRestaurant(RestaurantPojo r);
      List<RestaurantPojo> getAllRestaurant();
      RestaurantPojo getRestById(int rest_id);
      int deleteRestById(int rest_id);
      int updateRestById(int id,boolean isActive);
}
