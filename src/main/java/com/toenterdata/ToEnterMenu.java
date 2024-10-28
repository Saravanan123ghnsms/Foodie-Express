package com.toenterdata;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.Menu_Crud;
import com.food.modelclass.MenuPojo;

public class ToEnterMenu {
  public static void main(String[] args) {
	

    	 Scanner scan = new Scanner(System.in); 

    	
    	   while(true)
    	   {
    		   System.out.println("enter teh details");
    			int restaurantid=scan.nextInt();
    			scan.nextLine();
    	    	String itemname=scan.nextLine();
    	    	String description=scan.nextLine();
    	    	float price=scan.nextFloat();
    	    	boolean isactive=true;
    	    	String imagepath=scan.next();
    		    MenuPojo e = new MenuPojo();
    		    e.setRestaurant_id(restaurantid);
    		    e.setItemname(itemname);
    		    e.setDescription(description);
    		    e.setPrice(price);
    		    e.setIsActive(isactive);
    		    e.setImagepath(imagepath);;
    		    Menu_Crud obj=new Menu_Crud();
    		    obj.insertmenu(e);
    		    System.out.println("data added successfully");
    	   }
    }
}  
