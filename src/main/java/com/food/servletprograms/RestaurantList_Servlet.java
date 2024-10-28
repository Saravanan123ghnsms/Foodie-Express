package com.food.servletprograms;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO_Crud.Restaurant_Crud;
import com.food.modelclass.RestaurantPojo;
@WebServlet("/login")
public class RestaurantList_Servlet extends HttpServlet{
     @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	   Restaurant_Crud obj1=new Restaurant_Crud();
	    	  List<RestaurantPojo>  al =obj1.getAllRestaurant();
	    	  req.setAttribute("RestaurantList", al);
	    	  req.getSession().setAttribute("RestaurantList", al);
	    	  req.setAttribute("username", req.getParameter("username"));
	    	  req.setAttribute("password", req.getParameter("password"));
	    	  System.out.println("Control in restaruant servelt");
	    	  System.out.println((String)req.getParameter("username"));
	    	  System.out.println((String)req.getParameter("password"));
	    	  req.getRequestDispatcher("LoginServlet").include(req, resp);
    	  
    	  
       
    	  
    }
}
