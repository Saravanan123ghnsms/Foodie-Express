<%@page import="com.food.modelclass.UserPojo"%>
<%@page import="com.food.modelclass.RestaurantPojo"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant List</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

  <style>
    /* Navigation Bar Style */
    body
    {
       
      font-family: "Poppins", sans-serif;
      margin:0px 80px;
  
    }
    
    .navbar {
        display: flex;
        align-items: center;
        background-color: #FF7F2A; /* Orange background */
        padding: 5px;
        margin:0px 80px
        color: black;
        border-radius: 8px;
    }

    .navbar img {
        height: 50px; /* Logo height */
        margin-right: 20px; /* Space between logo and title */
        pading:10px;
        margin-left: 10px;
    }

    .navbar-title {
        font-size: 1.5em;
        font-weight: bold;
        margin-right: auto; /* Push links to the right */
    }

    .navbar a {
        color: white;
        text-decoration: none;
        margin: 0 15px; /* Space between links */
    }

    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {
        background-color: #f1f1f1;
    }

    .dropdown:hover .dropdown-content {
        display: block;
    }

    /* Container for the restaurants */
    .restaurant-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

    /* Individual restaurant card */
    .restaurant-card {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        margin: 10px;
        padding: 20px;
        width: 22%; /* Flex-basis for 4 restaurants per row */
        box-sizing: border-box;
        text-align: center;
        transition: transform 0.3s ease;
    }

    .restaurant-card:hover {
        transform: scale(1.05);
    }

    /* Restaurant image */
    .restaurant-image {
        width: 100%;
        height: 200px;
        object-fit: cover;
        border-radius: 8px;
    }

    /* Restaurant details */
    .restaurant-name {
        font-size: 1.2em;
        margin: 10px 0;
        font-weight: bold;
    }

    .restaurant-info {
        color: #666;
    }
     .submit-container {
        text-align: center;
        margin-top: 10px;
       
    }

    input[type="submit"]:hover {
        background-color:  #FF7043;
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
  
    

    /* Flex row break for responsiveness */
    @media screen and (max-width: 768px) {
        .restaurant-card {
            width: 48%; /* Show 2 per row on smaller screens */
        }
    }

    @media screen and (max-width: 480px) {
        .restaurant-card {
            width: 100%; /* Show 1 per row on very small screens */
        }
    }
</style>
  

</head>
<body>

      <!-- Navigation Bar -->
      
      <%  if((UserPojo)session.getAttribute("userobj")!=null)
      {   UserPojo obj = (UserPojo)session.getAttribute("userobj");
      %>
    <div class="navbar">
        <img src="https://images.crunchbase.com/image/upload/c_pad,h_256,w_256,f_auto,q_auto:eco,dpr_1/v1474145615/mfyi5brpgoq8va4qgvql.jpg" alt="Logo">
        <div class="navbar-title"><h2>Foodie Express</h2></div>
        <a href="CartItems.jsp">Cart</a>
        <a href="orderhistoryservlet">Order History</a>
        <div class="dropdown">
            <a href="javascript:void(0)">Hey, <%=obj.getUser_name() %></a>
            <div class="dropdown-content">
                <a href="Profile.jsp">Profile</a>
                <a href="ChangePassword.html">Change Password</a>
                <a href="Logout.jsp">Logout</a>
            </div>
        </div>
    </div>
    <%} 
      else {%>
       <div class="navbar">
        <img src="https://images.crunchbase.com/image/upload/c_pad,h_256,w_256,f_auto,q_auto:eco,dpr_1/v1474145615/mfyi5brpgoq8va4qgvql.jpg" alt="Logo">
        <div class="navbar-title"><h2>Foodie Express</h2></div>
        <a href="projectloginpage.html">Login</a>
        <a href="registrationpageproject.html">Register</a> 
     </div>
     <% } %>

    <div class="restaurant-container">
    <%  
       // Use session to retrieve the restaurant list
       List<RestaurantPojo> al = (List<RestaurantPojo>) session.getAttribute("RestaurantList");

       if (al != null) {
           for (RestaurantPojo obj : al) {
    %>
       <!-- Restaurant card -->
       <div class="restaurant-card">
           <img class="restaurant-image" src="<%= obj.getImagepath() %>" alt="Restaurant Image">
           <div class="restaurant-name"><%= obj.getRestaurantname() %></div>
           <div class="restaurant-info">
               Cuisine: <%= obj.getCuisinetype() %><br>
               Delivery Time: <%= obj.getDeliverytime() %> mins<br>
               Rating: <%= obj.getRating() %> <img alt="" src="https://img.freepik.com/free-psd/star-winner-rating-review-icon-sign-symbol-3d-background-illustration_56104-2417.jpg" height=16px width=20px>
           </div>
             <div class="submit-container">
         <form action="MenuServlet" method="GET">
         <input type="hidden" name="restaurantId" value="<%=obj.getRestaurantid()%>">
        <input type="submit" value="View Menu">
    </form>
</div>
             
       </div>
    <% 
           }
       } else {
           out.println("Restaurant list not available in the session.");
       }
    %>
    </div>

</body>
</html>
