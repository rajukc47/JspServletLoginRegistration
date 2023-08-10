<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Form </title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
  <%--<script>
    function validateForm(){


      var username = document.getElementById("username").value;
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;

      if(username == ""){

        alert("Enter Username.");
        this.focus();
        return false;
      }
      if(email == ""){
        alert("Enter Email.");
        this.focus();
        return false;
      }
      if(password == ""){
        alert("Enter Password.");
        this.focus();
        return false;
      }

    }
  </script>--%>
</head>
<body>
<div class="container">
  <div class="wrapper">
    <div class="title"><span>User Registration Form</span></div>
    <form name="register" action="user?page=register" method="post" onsubmit="validateForm()">
      <%
        String status = (String) request.getAttribute("status");
        if(status!=null && status.equals("success")){
          out.print("Registration Successful !");
        }
        if(status!=null && status.equals("failed")){
          out.print("Registration Failed !");
        }


      %>
      <div class="row">
        <i class="fas fa-user"></i>
        <input type="text" name="username" placeholder="Username" id="username">
      </div>
      <div class="row">
        <i class="fas fa-envelope"></i>
        <input type="text" name="email" placeholder="Email" id="email">
      </div>
      <div class="row">
        <i class="fas fa-address-book"></i>
        <input type="text" name="address" placeholder="Address" id="address">
      </div>
      <div class="row">
        <i class="fas fa-lock"></i>
        <input type="password" name="password" placeholder="Password" id="password">
      </div>
      <%--            <div class="pass"><a href="#">Forgot password?</a></div>--%>
      <div class="row button">
        <input type="submit" value="Register">
      </div>
      <div class="signup-link">Already a member? <a href="user?page=loginpage">Login Now</a></div>
    </form>
  </div>
</div>

</body>
</html>
