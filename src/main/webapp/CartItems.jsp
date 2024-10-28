<%@page import="org.apache.catalina.tribes.ChannelSender"%>
<%@page import="com.food.modelclass.Cart"%>
<%@page import="com.food.modelclass.CartItem"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Items List</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<style type="text/css">
body {
	font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 20px;
	background-color: #f8f8f8;
}

.cart-container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.cart-item {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	border-bottom: 1px solid #e0e0e0;
	padding: 10px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #e0e0e0;
}

.cart-item img {
	max-width: 600px;
	max-height: 150px;
	object-fit: cover;
	border-radius: 8px;
	margin-right: 150px;
}

.cart-details {
	flex-grow: 1;
	margin-left: 150px;
	text-align: left;
	max-width: 70%;
}

.cart-details p {
	margin: 5px 0;
	color: #333;
}

.cart-item:last-child {
	border-bottom: none;
}

.cart-empty {
	text-align: center;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.cart-empty p {
	font-size: 18px;
	color: #999;
}

input[type="submit"] {
	background-color: #FF5722;
	color: #fff;
	border: none;
	padding: 10px 10px;
	border-radius: 5px;
	margin-top: 3px;
	cursor: pointer;
	font-size: 1rem;
	font-weight: 600;
}

input[type="submit"]:hover {
	background-color: #FF7043;
}

input[type="number"] {
	padding: 10px;
	margin-top: 5px;
	margin-bottom: 5px;
	border-radius: 5px;
	border: 1px solid #ccc;
	font-size: 1rem;
}

a {
	color: white;
	text-decoration: none;
	font-size: 16px;
	font-family: 'Poppins', sans-serif;
	padding: 5px 10px;
	background-color: #c30e17;
	border-radius: 5px;
	font-weight: 510;
}

a:hover {
	color: white;
	background-color: #c30e17;
}

.spaced-link {
	display: inline-block;
	margin-top: 10px;
}
a.proceed_button[href]
{
    
    background-color:#c30e17 ;
    color: #fff;
    border: none;
    padding: 10px 10px;
    border-radius: 5px;
    margin-top: 3px;
    cursor: pointer;
    font-size: 1rem;
    font-weight: 600;
    display:inline-block; 
    text-align: center;
    margin-top: 30px;

}
a.proceed_button[href]:hover {
	background-color: #FF0000;
}

</style>
</head>
<body>
	<div class="cart-container">

		<%  Cart obj = (Cart)session.getAttribute("cart");
		       if(obj!=null)
		       {
               Map<Integer,CartItem>  mp = obj.getItems();
               if(mp!=null && !mp.isEmpty())
               {
            	 %><h1>Check Your Cart Items Here.</h1>
		<%
               for(int key :mp.keySet())
               { 
            	   CartItem cartitem = mp.get(key);
            	      session.setAttribute("restaurantId",cartitem.getRestaurantid());
            	   %>
		<div class="cart-item">
			<img alt="<%=cartitem.getName()%>"
				src=" <%=cartitem.getItemimage()%>" width="600px" height="300px">
			<div class="cart-details">
				<p>
					<strong>Item:</strong><%=cartitem.getName()%></p>
				<p>
					<strong>Price:</strong> $<%=cartitem.getPrice() %></p>
				<form action="cart">
					<p>
						<strong>Quantity:</strong><input type="number" name="quantity"
							value="<%=cartitem.getQuantity()%>">
					</p>
					<p>
						<strong>SubTotal:</strong> $<%=cartitem.getSubtotal()%></p>
					<input type="hidden" name="itemid"
						value="<%=cartitem.getItemid()%>"> <input type="submit"
						name="action" value="update"> <input type="submit"
						name="action" value="delete">
				</form>
				<a href="MenuServlet?restaurantId=<%=cartitem.getRestaurantid()%>"
					class="spaced-link">Add More Items</a>
			</div>

		</div>

		<%  }
		
               }
		       }
               
               else
               {%>
		<div class="cart-empty">
			<h1>No Items in the Cart .Your Cart is Empty</h1>
		</div>
		<%}
            
            %>
            </div>
            <%if(obj!=null) 
            {%>
            <div style="text-align: center">
	   <a href="Checkout.jsp" class="proceed_button">Proceed to Check Out</a>
	   </div>
	   <%} %>
</body>
</html>