package com.food.servletprograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAOInterface.MenuDAO;
import com.food.DAO_Crud.Menu_Crud;
import com.food.modelclass.MenuPojo;

public class RegisterMenuItems extends HttpServlet {
     @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String restaurant_id1=req.getParameter("restaurantid");
         int restaurant_id=Integer.parseInt(restaurant_id1);
         String itemname=req.getParameter("Itemname");
         String description=req.getParameter("description");
         String price1=req.getParameter("price");
         int price=Integer.parseInt(price1);
         String isActive1=req.getParameter("isActive");
         boolean isActive=(isActive1.equals("Yes"))? true:false;
         String imagepath=req.getParameter("imagepath");
         PrintWriter pw=resp.getWriter();
         
         MenuPojo menuobj=new MenuPojo(restaurant_id, itemname, description, price, isActive, imagepath);
         Menu_Crud obj=new Menu_Crud();
         int res=obj.insertmenu(menuobj);
         if(res!=0)
         {
        	 pw.println("Successfully added menuitem to the database");
         }
         else {
        	 pw.println("Cannot add menuitem to the database");
		}
         
    }
}
