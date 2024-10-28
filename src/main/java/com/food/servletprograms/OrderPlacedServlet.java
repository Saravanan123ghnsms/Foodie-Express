package com.food.servletprograms;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO_Crud.OrderHistoryCRUD;
import com.food.DAO_Crud.Orders1_Crud;
import com.food.DAO_Crud.OrdersItems_CRUD;
import com.food.modelclass.Cart;
import com.food.modelclass.CartItem;
import com.food.modelclass.OrderHistoryPojo;
import com.food.modelclass.Orders1Pojo;
import com.food.modelclass.OrdersItemsPojo;
import com.food.modelclass.UserPojo;

@WebServlet("/orderplaced")
public class OrderPlacedServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Control reached order placed servelt");

		Cart obj = (Cart) req.getSession().getAttribute("cart");
		HttpSession session = req.getSession();
		UserPojo userobj = (UserPojo) session.getAttribute("userobj");
		int userid = userobj.getUserid();
		String paymentoption = req.getParameter("paymentoption");
		float total = Float.parseFloat(req.getParameter("total"));
		int resid = Integer.parseInt(req.getParameter("resid"));
		System.out.println(req.getParameter("resid"));
		System.out.println(userid);
		System.out.println(paymentoption);
		System.out.println(total);
 ////     inserting data for orderspojo table 
		Orders1Pojo orderobj = new Orders1Pojo();
		orderobj.setUserid(userid);
		orderobj.setPaymentoptions(paymentoption);
		orderobj.setRestaurantid(resid);
		orderobj.setTotalamount(total);

		Orders1_Crud orderobjcrud = new Orders1_Crud();
		int res = orderobjcrud.insertOrder(orderobj);
		if (res != 0) {
			System.out.println("data inserted successfully");
		}
		int maxid = orderobjcrud.maxorderId();
	
		// insertng data for order items table
		
		Map<Integer, CartItem> map = obj.getItems();
		for (int key : map.keySet()) {
              int orderid=maxid;
              int menuid=map.get(key).getItemid();
              int quantity=map.get(key).getQuantity();
              float subtotal=map.get(key).getSubtotal();
              OrdersItemsPojo itemobj = new OrdersItemsPojo();
              itemobj.setMenuid(menuid);
              itemobj.setOrderid(orderid);
              itemobj.setQuantity(quantity);
              itemobj.setSubtotal(subtotal);
              OrdersItems_CRUD cruditemobj = new OrdersItems_CRUD();
              if(cruditemobj.insertOrderItems(itemobj)!=0)
              {
            	   System.out.println("item inserted successfully");
              }
              
		}
		
		///for order history 
		int huserid=userid;
		int horderid=maxid;
		float htotal=total;
		OrderHistoryPojo hobj = new OrderHistoryPojo();
		hobj.setOrderid(horderid);
		hobj.setUser_id(huserid);
		hobj.setTotalamount(htotal);
		OrderHistoryCRUD hobjcrud = new OrderHistoryCRUD();
		int num=hobjcrud.insertOrderHistory(hobj);
		 if(num!=0)
		 {
			 System.out.println("history updated successfully");
		 }
         resp.sendRedirect("OrderSuccess.html");
	}
}
