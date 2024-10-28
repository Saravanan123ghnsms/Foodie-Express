<%@page import="com.food.modelclass.UserPojo"%>
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
 body
    {
        font-family: "Poppins", sans-serif;
        margin:0px 80px;
    }
    .profile
    {
        border:3px solid black;
        margin: 0px 300px;
        margin-top: 100px;
        background-color: rgb(216, 26, 42);
        color: white;
        border-radius: 15px;
        padding: 100px 200px;
        text-align: center;
     
    }
    h2
    {
        margin-bottom: 90px;
    }
    table td,th{
        line-height: 3rem;
    }
    td{
          padding-left: 2rem;    
    }
    input[type="text"],
    input[type="password"] {
      
        padding: 10px;
        margin-bottom: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        font-size: 1rem;

    }
</style>
</head>
<body>
    <% UserPojo userobj = (UserPojo) session.getAttribute("userobj"); %>
       <div class="profile">
    <h2>Profile Information</h2>
    <table>
       <tr>
              <td>UserName: </td>
              <td><input type="text" value="<%=userobj.getUser_name() %>"></td>
        </tr>
         <tr>
              <td>Email: </td>
              <td><input type="text" value="<%=userobj.getEmail()%>"></td>
        </tr>
         <tr>
              <td>Phonenumber: </td>
              <td><input type="text" value="<%=userobj.getPhonenumber()%>"></td>
        </tr>
         <tr>
              <td>Address: </td>
              <td><input type="text" value="<%=userobj.getAddress()%>"></td>
        </tr>
       
    </table>
    </div>
     
</body>
</html>