package com.food.servletprograms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO_Crud.UserCrud;
import com.food.modelclass.UserPojo;

public class RegistrationServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_name = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phonenumber1=req.getParameter("phonenumber");
		long phonenumber=Long.parseLong(phonenumber1);
	
        PrintWriter pw = resp.getWriter();

		if (password.equals(cpassword)) {
			UserPojo userobj = new UserPojo();
			userobj.setUser_name(user_name);
			userobj.setPassword(password);
			userobj.setEmail(email);
			userobj.setAddress(address);
			userobj.setPhonenumber(phonenumber);
			UserCrud userins = new UserCrud();
			int rs=userins.insertUser(userobj);
			if(rs!=0)
			{
				resp.sendRedirect("registrationsuccess.html");
			}
		} else {
			pw.println("Password and confirm password does not match.");

		}
	}
}
