package com.food.DAOInterface;

import java.util.List;

import com.food.modelclass.OrdersItemsPojo;

public interface OrdersItemsDAO {
   int insertOrderItems(OrdersItemsPojo obj);
   List<OrdersItemsPojo> fetchOrdersItems(int orderid);
}
