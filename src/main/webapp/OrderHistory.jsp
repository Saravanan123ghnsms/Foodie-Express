<%@page import="com.food.modelclass.OrderHistoryPojo"%>
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
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<style>
 
     body {
	font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 20px;
	background-color: #f8f8f8;
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
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
 

  
</style>
</head>
<body>
     <% if((List<OrderHistoryPojo>) session.getAttribute("orderhistorylist")!=null)
     {
    	   List<OrderHistoryPojo> list = (List<OrderHistoryPojo>)session.getAttribute("orderhistorylist");
    	   %>
       <h2>Check Your Orders Below.</h2>
       <table>
         <tr>
          <td>S.no</td>
         
          <td>OrderDate</td>
          <td>Totalamount</td>
          <td>Status</td>
          <td>CheckItems</td>
         </tr>
       <%  int increment=1;
       for(OrderHistoryPojo e:list)
    	   {
    	   %>
    	  
    	    <tr>
    	    <td><%=increment++ %></td>
    	
    	    <td><%=e.getDateandtime() %></td>
    	    <td><%=e.getTotalamount() %></td>
    	     <td><%=e.getStatus() %></td>
    	     <td><form action="OrderItemList">
    	     <input type="hidden" name="orderid" value="<%=e.getOrderid() %>">
    	     <input type="submit" name="View Menu">
    	     </form></td>
    	    </tr>
    	    <%
    	     }
    	     }%>
    	
     
       
</body>
</html>