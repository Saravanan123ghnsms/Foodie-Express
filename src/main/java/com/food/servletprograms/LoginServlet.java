package com.food.servletprograms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO_Crud.UserCrud;
import com.food.modelclass.RestaurantPojo;
import com.food.modelclass.UserPojo;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	  String  username=(String)req.getParameter("username");
        	  String password=(String)req.getParameter("password");
        	  UserCrud obj=new UserCrud();
        	  UserPojo userobj= obj.selectSpecific(username);
        	  System.out.println("control in login servlet");
        	  System.out.println(username);
        	  System.out.println(password);
        	  if(username.equals(userobj.getUser_name()) && password.equals(userobj.getPassword()))
        			  {
        	  req.setAttribute("userobj", userobj);
        	  req.getSession().setAttribute("userobj", userobj);
        	  req.getRequestDispatcher("HomePage.jsp").include(req, resp);
        			  }
        	  else {
        		  resp.getWriter().println("Incorrect Password or Username");
			}
        	  
//              PrintWriter pw=resp.getWriter();
//         
//              if(userobj!=null) {
//            	  if(password.equals(userobj.getPassword()))
//            	  {
//            		
//            		  pw.println("Login successful");
//            	  }
//            	  else
//            	  {
//            		  pw.println("Incorrect password");
//            	  }
//              }
//              else
//              {   
//            	  resp.sendRedirect("registrationpageproject.html");
//              }
            
        }
} 
