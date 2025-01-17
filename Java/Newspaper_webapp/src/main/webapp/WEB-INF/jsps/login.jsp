<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/styles.css">



<title>Login</title>
</head>
<body>

<!--------------------------------------------------Header----------------------------------------------------------->

<header>


<div class="header">
  <h1>Real News</h1>
  <p>We are totally fake!!!</p>
  
</div>

<!--------------------------------------------------For Anonymous User-------------------------------------------------->
<c:if test="${user.isPresent() == false }">

<div class="navbar">
  <a href="/index">HEADLINES</a>
  <a href="/index/UK">UK</a>
  <a href="/index/SPORTS">SPORTS</a>
  <div class="dropdown">
    <button class="dropbtn">ALL CATEGORIES 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      
     <c:forEach items="${category}" var="category">
						
	 <a href="/index/${category.getName()}">${category.getName()}</a>
	</c:forEach>
      
    </div>
  </div> 
   <div class="search-container">
    <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <input type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
</header>
</c:if>

<!-- ------------------------------------------------------------------------------------------------------------------------ -->
	
	<div id="login">
	
	<h3>Login</h3>

	<form action="/login" method="post">
		<div>
			<label for="username">Username:</label>
			<input type="text" name="username" placeholder="User name">
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" placeholder="Password">		
		</div>
		<input type="submit" value="Log in">
	</form>
	<br/><a href="/register">Register</a>
	</div>
</body>
</html>