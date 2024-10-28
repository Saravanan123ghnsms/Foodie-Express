package com.food.servletprograms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.OrderHistoryCRUD;
import com.food.modelclass.OrderHistoryPojo;
import com.food.modelclass.UserPojo;
@WebServlet("/orderhistoryservlet")
public class OrderHistoryServlet  extends HttpServlet{
         @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	    UserPojo userobj = (UserPojo)req.getSession().getAttribute("userobj");
        	    int userid=userobj.getUserid();
        	    OrderHistoryCRUD  orderhistoryobj = new OrderHistoryCRUD();
        	List<OrderHistoryPojo> orderhistorylist=orderhistoryobj.fetchOrderOnUserid(userid);
             req.getSession().setAttribute("orderhistorylist", orderhistorylist);
             resp.sendRedirect("OrderHistory.jsp");
             
        	    
        }
}
