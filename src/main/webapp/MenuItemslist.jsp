<%@page import="com.food.modelclass.MenuPojo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Items list</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<style type="text/css">
      body {
        font-family: 'Poppins', sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #f8f8f8;
    }
    .menu-container {
        max-width: 800px;
        margin: 0 auto;
    }
    .menuitem {
        background-color: #fff;
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
    .menuitem h3 {
        margin: 0;
        font-size: 22px;
        color: #333;
    }
    .menuitem p {
        margin: 10px 0;
        color: #666;
        font-size: 16px;
    }
    .menuitem img {
        display: block;
        max-width: 100%;
        height: auto;
        margin-top: 10px;
        border-radius: 6px;
    }
    .menuitem .price {
        font-weight: 500;
        color: #ff5722;
        font-size: 18px;
    }
    .quantity_details
    {
      text-align: right;
      margin-top: 50px;	
    }
    
        input[type="submit"] {
        background-color:#FF5722;
        color: #fff;
        border: none;
        padding: 10px 10px;
        border-radius: 5px;
        margin-top:3px;
        cursor: pointer;
        font-size: 1rem;
        font-weight: 600;

    }
       input[type="submit"]:hover {
        background-color:  #FF7043;
    }
 
       input[type="number"] {
       /* width: calc(100% - 20px);*/
        padding: 10px;
        margin-bottom: 20px;
        border-radius: 5px;
        border: 1px solid #ccc;
        font-size: 1rem;
    }
</style>
</head>
<body>
<div class="menu-container">
<%
      List<MenuPojo> menulist=(List<MenuPojo>) request.getAttribute("menulist");
      if(menulist!=null)
      { 
    	  for(MenuPojo e:menulist)
    	  { %>
    	  <div class="menuitem">
    	     <h3><%=e.getItemname() %></h3>
    	     <p><%=e.getDescription() %></p>
    	      <p class="price">Price: ₹<%= e.getPrice() %></p>
    	     <img alt="<%=e.getItemname() %>" src="<%=e.getImagepath()%>">
    	     
    	     <form action="cart">
    	     <div class="quantity_details">
    	     <input type="hidden" name="itemid" value="<%=e.getMenuid()%>">
    	     <p>Quantity</p>
    	     <input type="number" name="quantity" min="1" value="1">
    	     <input type="hidden" name="action" value="add">
    	     <input type="submit" name="Add to Cart">
    	     </div>
    	     </form>
    	   </div>
   	  
    	  <%}
      }
      else{
    	  out.println("No menu items found in requested restaurant.");
      } %>
     
      </div>
</body>
</html>