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

<title>My Articles</title>
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

<h2>Create Article</h2>
<form method="post" action="/createArticle">
<input type="text"  name="category" placeholder="Category" value="${category}"/>
<br />
<br />

<input type="text" style="width:50%;" name="title" placeholder="Title" value="${title}"/>
<br />
<br />
<input type="submit" value="Create"/>


</form>

<br />
<br />




<br />
<br />
<!------------------------------Articles need re-editing----------------------------------------------------------->

<h3 style="color:red;">Articles that need correction : </h3>
<table>

<tr>
	<th>No.</th>
    <th>Category</th>
    <th>Title</th>
    <th>Editor</th>
    <th>Action</th>
   
  </tr>
<c:forEach items="${myArticles}" var="myArticles" varStatus="num">

<c:if test="${myArticles.isReEdit() == true and myArticles.isInReview() == true and myArticles.isPublished() == false}">
    

  <tr>
    <td>${num.count}</td>
    <td>${myArticles.getCategory().getName()}</td>
    <td>${myArticles.getTitle()}</td>
    <td>${myArticles.getEditor().getUsername()}</td>
    <td><a href="/edit/${myArticles.getId()}">Edit</a></td>
   
  </tr>

</c:if>
</c:forEach>
</table>
<br />
<br />

<!------------------------------Articles in Review----------------------------------------------------------->

<h3>Articles being reviewed : </h3>
<table>

<tr>
	<th>No.</th>
    <th>Category</th>
    <th>Title</th>
   
  </tr>
<c:forEach items="${myArticles}" var="myArticles" varStatus="num">
 <c:if test="${myArticles.isInReview() == true and myArticles.isReEdit() == false and myArticles.isPublished() == false}"> 

  

  <tr>
  	<td>${num.count}</td>
    <td>${myArticles.getCategory().getName()}</td>
    <td>${myArticles.getTitle()}</td>
   
  </tr>
</c:if>

</c:forEach>
</table>
<br />
<br />

<!------------------------------Published Articles----------------------------------------------------------->

<h3>Published Articles : </h3>
<table>

<tr>
	<th>No.</th>
    <th>Category</th>
    <th>Title</th>

  </tr>
<c:forEach items="${myArticles}" var="myArticles" varStatus="num">

 <c:if test="${myArticles.isPublished() == true}"> 
  

  <tr>
  	<td>${num.count}</td>
    <td>${myArticles.getCategory().getName()}</td>
    <td>${myArticles.getTitle()}</td>
    
  </tr>

</c:if>
</c:forEach>
</table>

<br />
<br />

<!------------------------------Saved Articles----------------------------------------------------------->

<h3>Saved Articles : </h3>
<table>

<tr>
    <th>No.</th>
    <th>Category</th>
    <th>Title</th>
    <th>Action</th>
  </tr>
<c:forEach items="${myArticles}" var="myArticles" varStatus="num">

<c:if test="${myArticles.isInReview() == false and myArticles.isReEdit() == false and myArticles.isPublished() == false}"> 
   

  <tr>
  	<td>${num.count}</td>
    <td>${myArticles.getCategory().getName()}</td>
    <td>${myArticles.getTitle()}</td>
    <td><a href="/edit/${myArticles.getId()}">Edit</a></td>
  </tr>

</c:if>
</c:forEach>
</table>
</div>
</body>
</html>