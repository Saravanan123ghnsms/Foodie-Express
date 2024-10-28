package com.food.servletprograms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO_Crud.Menu_Crud;
import com.food.modelclass.MenuPojo;
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  System.out.println("control reached menuservlet");
     int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
	
       Menu_Crud menuobj=new Menu_Crud();
     List<MenuPojo> menulist=  menuobj.getMenuByRestaurantId(restaurantId);
      System.out.println(menulist);
    
     req.setAttribute("menulist", menulist);
     req.getRequestDispatcher("MenuItemslist.jsp").forward(req, resp);
     
     
}
}
