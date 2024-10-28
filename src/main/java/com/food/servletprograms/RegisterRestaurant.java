package com.food.servletprograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.Restaurant_Crud;
import com.food.modelclass.RestaurantPojo;

public class RegisterRestaurant extends HttpServlet{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String restaurantid1=req.getParameter("restaurantid");
	    int restaurantid=Integer.parseInt(restaurantid1);
        String restaurantname=req.getParameter("restaurantname");
        String cuisinetype=req.getParameter("cuisinetype");
        String deliverytime1=req.getParameter("deliverytime");
        int deliverytime=Integer.parseInt(deliverytime1);
        String isActive1=req.getParameter("isActive");
        boolean isActive=(isActive1.equals("Yes")?true:false);
        String rating1=req.getParameter("rating");
        int rating=Integer.parseInt(rating1);
        String imagepath=req.getParameter("imagepath");
       PrintWriter pw= resp.getWriter();
//        System.out.println("Control reached the servlet");
//        System.out.println(restaurantname);
//        System.out.println(cuisinetype);
//        System.out.println(deliverytime);
//        System.out.println(isActive);
//        System.out.println(rating);
//        System.out.println(imagepath);
        RestaurantPojo resobj = new RestaurantPojo(restaurantid,restaurantname, cuisinetype, deliverytime, isActive, rating, imagepath);
        Restaurant_Crud rescrud=new Restaurant_Crud();
        int res=rescrud.insertRestaurant(resobj);
        if(res!=0)
        {
        	pw.println("Registraion of Restaurant is successful");
        }
        else {
			pw.println("Registration Failure");
		}
        
}
}
