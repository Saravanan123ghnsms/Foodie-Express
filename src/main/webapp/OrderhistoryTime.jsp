<%@page import="com.food.DAO_Crud.Menu_Crud"%>
<%@page import="com.food.modelclass.MenuPojo"%>
<%@page import="com.food.modelclass.OrdersItemsPojo"%>
<%@page import="com.food.servletprograms.OrderItemListServlet"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
  
  
</style>
</head>
<body>
  
   <% List<OrdersItemsPojo> li = (List<OrdersItemsPojo>)request.getAttribute("orderitemlist");
       int serialnumber=1;
       float total=0;%>
         <table>
        <tr>
        <td>S.No</td>
        <td>ItemImage</td>
        <td>ItemName</td>
        <td>Quantity</td>
        <td>SubTotal</td>
        </tr>
       
     <% for(OrdersItemsPojo e:li)
       {
    	  Menu_Crud obj = new Menu_Crud();
    	  MenuPojo menuobj= obj.getMenubyMenuId(e.getMenuid());
       %>
     
       <tr>
      <td> <p><%=serialnumber++ %></p></td>
      <td> <img alt="<%=menuobj.getItemname()%>" src="<%= menuobj.getImagepath()%>"></td>
       <td><p><%=menuobj.getItemname()%></p></td>
      <td> <p><%=e.getQuantity() %></p></td>
      <td> <p><%=e.getSubtotal() %></p></td>
       </tr>
       <%total+=e.getSubtotal();
       } %>
       <tr>
          <td></td>
          <td><p>Total</p></td>
          <td></td>
          <td></td>
          <td><%=total %></td>
       </tr>
</body>
</html>