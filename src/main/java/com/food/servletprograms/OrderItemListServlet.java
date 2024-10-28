package com.food.servletprograms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.OrdersItems_CRUD;
import com.food.modelclass.OrdersItemsPojo;
@WebServlet("/OrderItemList")
public class OrderItemListServlet extends HttpServlet{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int orderid =Integer.parseInt(req.getParameter("orderid"));
	 System.out.println("control reached in orderitem servlet");
	 OrdersItems_CRUD orderitemobj = new OrdersItems_CRUD();
	 List<OrdersItemsPojo> list = orderitemobj.fetchOrdersItems(orderid);
	 System.out.println(list);
     req.setAttribute("orderitemlist", list);
     req.getRequestDispatcher("OrderhistoryTime.jsp").include(req, resp);
     
}
}
