<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.food.modelclass.Cart"%>
<%@page import="com.food.modelclass.CartItem"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout orders - list</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<style type="text/css">
  body {
	font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 20px;
	background-color: #f8f8f8;
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}
 img {
      width: 150px;  
      height: auto;  
      border-radius: 5px;
  }
  
  
  table {
      width: 100%;
      border-collapse: collapse;
  }
   td, th {
      padding: 10px;
      border-bottom: 1px solid #ddd;
      text-align: center;
      line-height: 1rem;
  }
  form table {
    margin-top:30px;
    border: none;
    border-collapse: separate; /* Prevent collapsing borders */
    border-spacing: 15px 15px;
}

form table td,th{
    border: none; /* Remove borders from table cells */
    padding: 5px; /* Optional: Add some padding for a cleaner look */
   
}


select
{
    font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 5px;
	background-color: #f8f8f8;
	border-radius: 4px;
}
textarea
{
   border-radius:5px;
   font-family: 'Poppins', sans-serif;
    padding:15px;
}
.confirm_order
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
    text-decoration: none;

}


</style>
</head>
<body>

   <h1>Check your order details below.</h1>
   <table>
    <tr>
          <td>Item Image</td>
          <td>Item Name</td>
          <td>Item price</td>
          <td>Item Quantity</td>
          <td>Item Subtotal</td>
     </tr>
     
       <% Cart obj= (Cart)session.getAttribute("cart");
       Map<Integer,CartItem> list = obj.getItems();
       float total=0;
       for(int key:list.keySet())
       { %>
         <tr>
          <td><img alt="<%=list.get(key).getName()%>" src="<%=list.get(key).getItemimage()%>"></td>
          <td><p><%=list.get(key).getName()%></p></td>
          <td><p><%=list.get(key).getPrice()%></p></td>
          <td><p><%=list.get(key).getQuantity()%></p></td>
          <td><p><%=list.get(key).getSubtotal()%></p></td>
        </tr>
        <%
         total+=list.get(key).getSubtotal();
       }
      
         %>
      <tr>
          <td></td>
          <td><p>Total</p></td>
          <td></td>
          <td></td>
          <td><p><%=total%></p></td>
      </tr>
    
   </table>
   
   <form action="orderplaced">
   <table>

      <tr>
               <td>Payment Mode</td>
               <td> <select name="paymentoption">
                      <option value="Cash" >Cash</option>
                      <option value="DebitCard" >Debit Card</option>
                      <option value="CreditCard" >Credit Card</option>
                      <option value="UPI" >UPI</option>
                    </select><br>
               </td>
      </tr>
      <tr>
         <td>Address:</td>
         <td><textarea rows="10" cols="50" style="width:50%;"></textarea></td>
      </tr>
   </table>
   
   
    <div style="text-align: center">
       <input type="hidden" name="total" value="<%=total%>">
       <input type="hidden" name="resid" value="<%=session.getAttribute("restaurantId") %>">
 	   <input type="submit" class="confirm_order" value="Confirm Order">
	 
	  </div>
 </form>
</body>
</html>