package com.food.DAOInterface;

import java.util.List;

import com.food.modelclass.OrderHistoryPojo;

public interface OrderHistoryDAO {
    List<OrderHistoryPojo> fetchOrderOnUserid(int userid);
    int  insertOrderHistory(OrderHistoryPojo obj);
    int updateOrderHistory(int historyid,String status);
}
