package com.food.servletprograms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOInterface.MenuDAO;
import com.food.DAO_Crud.Menu_Crud;
import com.food.modelclass.Cart;
import com.food.modelclass.CartItem;
import com.food.modelclass.MenuPojo;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println("control reachd the cartservelt");

		// collection the cart object from the session if the cart is not there it will
		// display null
		// so i am going to create object for the cart in the if block and set the cart
		// object in the session
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		// collection action attribute from the form checking the action using if else
		// block
		String action = (String) req.getParameter("action");
		System.out.println(action);
		if (action.equals("add")) {
			addItemtoCart(req, cart);
		} else if (action.equals("update")) {
			updateItemtoCart(req, cart);
		} else if (action.equals("delete")) {
			removeItemtoCart(req, cart);
		}
		session.setAttribute("cart", cart);
		session.setMaxInactiveInterval(7*24*60*60);
		resp.sendRedirect("CartItems.jsp");
	}

	// method to add item to the cart
	public void addItemtoCart(HttpServletRequest req, Cart cart) {
              int itemid = Integer.parseInt(req.getParameter("itemid"));
              int quantity = Integer.parseInt(req.getParameter("quantity"));
              System.out.println(itemid);
              System.out.println(quantity);
              Menu_Crud menuobj = new Menu_Crud();
              MenuPojo menuitem =menuobj.getMenubyMenuId(itemid);
              if(menuitem!=null)
              {
            	  CartItem  cartitem = new CartItem();
            	  cartitem.setItemid(menuitem.getMenuid());
            	  cartitem.setRestaurantid(menuitem.getRestaurant_id());
            	  cartitem.setName(menuitem.getItemname());
            	  cartitem.setPrice(menuitem.getPrice());
            	  cartitem.setQuantity(quantity);
            	  cartitem.setSubtotal(quantity*menuitem.getPrice());
            	  cartitem.setItemimage(menuitem.getImagepath());
            	  
                  //storing cartitem to the cart list
                  cart.addItem(cartitem);
              }
              System.out.println(menuitem);
               

 
	}

	// method to update the item in the cart
	public void updateItemtoCart(HttpServletRequest req, Cart cart) {
          int itemid = Integer.parseInt(req.getParameter("itemid"));   
          int quantity = Integer.parseInt(req.getParameter("quantity"));
          cart.updateItem(itemid, quantity);
          System.out.println("updated item successfully");
		
	}

	// method to delete the item in the cart
	public void removeItemtoCart(HttpServletRequest req, Cart cart) {
            int itemid = Integer.parseInt(req.getParameter("itemid"));
            cart.removeItem(itemid);
            System.out.println("Removeditem successfully occured");
	}

}
