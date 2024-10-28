package com.food.servletprograms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.UserCrud;
import com.food.modelclass.UserPojo;
@WebServlet("/updatepassword")
public class PasswordUpdate extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                       System.out.println("Control reached the password update servlet");
        	    String password = req.getParameter("newpassword");
        	    String confirmpassword=req.getParameter("confirmpassword");
        	UserPojo userobj  =   (UserPojo) req.getSession().getAttribute("userobj");
        
        	    if(password.equals(confirmpassword))
        	    {
        	    	UserCrud obj  = new UserCrud();
        	    	obj.update(confirmpassword, userobj.getUserid());
        	    	resp.sendRedirect("changedpasswordsuccess.html");
        	    }
        	    else {
					resp.getWriter().println("Password and confirmpassword doesnt match");
				}
        	
        }
}
