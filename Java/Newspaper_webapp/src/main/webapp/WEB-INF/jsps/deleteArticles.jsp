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


<link rel="stylesheet" href="/css/styles.css">
<title>Review Articles</title>
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
    <form method="post" action="/search">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>


</header>
</c:if>

<!--------------------------------------------------For Customer--------------------------------------------------------->

<c:if test="${user.isPresent() == true }">
<c:if test="${user.get().getRole().getRoleName() == 'Customer' }">

<div class="navbar">
  <a href="/home">HOME</a>
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
    <form method="post" action="/search">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
</header>
</c:if>
</c:if>


<!--------------------------------------------------For Contributor--------------------------------------------------------->

<c:if test="${user.isPresent() == true }">
<c:if test="${user.get().getRole().getRoleName() == 'Contributor' }">

<div class="navbar">
  <a href="/home">HOME</a>
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
    <form method="post" action="/search">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
</header>

<div class="topnav">
  <a href="/myArticles">MY ARTICLES</a>
</div>

</c:if>
</c:if>

<!--------------------------------------------------For Editor--------------------------------------------------------->

<c:if test="${user.isPresent() == true }">
<c:if test="${user.get().getRole().getRoleName() == 'Editor' }">

<div class="navbar">
  <a href="/home">HOME</a>
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
    <form method="post" action="/search">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
</header>

<div class="topnav">
  <a href="/myArticles">MY ARTICLES</a>
  <a href="/reviewArticles">REVIEW ARTICLES</a>
  <a href="/myReviewArticles">MY REVIEW ARTICLES</a>
</div>

</c:if>
</c:if>

<!--------------------------------------------------For Admin--------------------------------------------------------->

<c:if test="${user.isPresent() == true }">
<c:if test="${user.get().getRole().getRoleName() == 'Admin' }">

<div class="navbar">
  <a href="/home">HOME</a>
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
    <form method="post" action="/search">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>
</header>

<div class="topnav">
  <a href="/createUsers">CREATE USERS</a>
  <a href="/deleteArticles">DELETE ARTILCES</a>
</div>

</c:if>
</c:if>

<!--------------------------------------------------Header-ends-here----------------------------------------------------->






<div id="edit">


<div class="search-container">
    <form method="post" action="/deleteSearch">
      <input type="text" placeholder="Search.." name="search">
      <input name="date" type="date"/>
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>





<h2>Delete Articles</h2>


<table>

<tr>
	<th>No.</th>
    <th>Category</th>
    <th>Title</th>
    <th>Action</th>
   
  </tr>
<c:forEach items="${articles}" var="articles" varStatus="count">


  

  <tr>
  	<td>${count.count}</td>
    <td>${articles.getCategory().getName()}</td>
    <td>${articles.getTitle()}</td>
    <td><a href="/deleteArticle/${articles.getId()}">Delete article</a></td>
   
  </tr>


</c:forEach>
</table>
<br />
<br />
</div>
</body>
</html>