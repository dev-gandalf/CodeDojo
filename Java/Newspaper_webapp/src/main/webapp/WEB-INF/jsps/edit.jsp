<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />

<script
	src="https://cdn.tiny.cloud/1/viv3mfwt9iz34piln2ts71b8rgz3tn0rar8w0vjdhnuwaoyp/tinymce/6/tinymce.min.js"
	referrerpolicy="origin"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="/css/styles.css">

		<title>Edit Article</title>
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
	
	<h2>Edit Article</h2>


	<c:if
		test="${user.get().getUsername() == article.getEditor().getUsername()}">
		<p style="color: red;">(Please Save before Publishing)</p>
		<form method="post" action="/publish">

			<label>Publish article</label> <input type="hidden" name="articleId"
				value="${article.getId()}" /> <input type="checkbox"
				name="headlines" value="true" /><label>Headlines</label> <input
				type="submit" value="publish" />

		</form>
	</c:if>

	<br />
	<br />


	<form method="post" action="/edit">

		<input type="hidden" name="id" value="${article.getId()}" /> <input
			type="text" name="category" placeholder="Category"
			value="${article.getCategory().getName()}" /> <br /> <br /> <input
			type="text" style="width: 99%;" name="title" placeholder="Title"
			value="${article.getTitle()}" /> <br /> <br />

		<textarea name="article">
     ${article.getArticle()}
  </textarea>
		<script>
			tinymce
					.init({
						selector : 'textarea',
						plugins : 'anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed linkchecker a11ychecker tinymcespellchecker permanentpen powerpaste advtable advcode editimage tableofcontents footnotes mergetags autocorrect',
						toolbar : 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | addcomment showcomments | spellcheckdialog a11ycheck | align lineheight | checklist numlist bullist indent outdent | emoticons charmap | removeformat',

					});
		</script>

		<br /> <input type="submit" value="save" />
	</form>

	<p style="color: red;">(Please Save before performing any of the
		below actions)</p>


	<c:if
		test="${user.get().getUsername() == article.getContributor().getUsername() and user.get().getUsername() != article.getEditor().getUsername()}">
		<br />
		<a href="/myArticles">Return to my articles</a>
		<br /><br /><br />
		<a href="/review/${article.getId()}">Send for review</a>
	</c:if>



	<c:if
		test="${user.get().getUsername() == article.getEditor().getUsername() and user.get().getUsername() != article.getContributor().getUsername() }">
		<br />
		<a href="/myReviewArticles">Return to my review articles</a>
		<br /><br /><br />
		<a href="/review/needsEdit/${article.getId()}">Send for Correction</a>

	</c:if>




	<c:if
		test="${user.get().getUsername() == article.getEditor().getUsername() and user.get().getUsername() == article.getContributor().getUsername() }">
		<br />
		<a href="/myArticles">Return to personal articles</a>
		<br /><br /><br />
		<a href="/myReviewArticles">Return to my review articles</a>

	</c:if>

</div>
</body>
</html>