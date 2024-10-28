package com.food.DAOInterface;

import com.food.modelclass.Orders1Pojo;

public interface Orders1DAO {
     int updateStatus(int orderid,String status);
     int insertOrder(Orders1Pojo e);
      Orders1Pojo fetchOrderDatailsByOrderid(int orderid);
     
}
