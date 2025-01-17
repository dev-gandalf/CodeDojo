<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Search</title>

<link rel="stylesheet" href="/css/style.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap"
	rel="stylesheet" />
</head>
<body>

	<div class="allButFooter">
		<header id="navigation">
			<div class="wrapper">
				<a class="scroll" href="/"> <img class="logo"
					src="/pictures/Logo.png"
					alt="Shazar logo. Golden diamond with Shazar name inside." />
				</a> <a href="/"><h1 class="scroll">Shazar</h1></a>

				<!-- Chat Icon -->
				<a href="/chats"><div class="icon">&#9993;</div></a>

			</div>
		</header>

		<section id="search-bar">
			<form method="post" action="/search">
				<div>
					<div>
						<input class="search-bar" type="text" name="keyword"
						placeholder="&#128269 Search Items" value="${keyword != null ? keyword : ''}"/> 
						<input type="submit"
						class="button_active" value="Submit" value="/search" />
					</div>
				</div>
					<div>
						<div>
						
							<input type="checkbox" name="isDateSearch" value="true" <c:if test="${isDateSearch == 'true'}">checked=checked</c:if>>
							<label>time range</label>
							<input type="date" id="date" name="startDate" value="${startDate != null ? startDate : '2022-01-08'}"/>
							<input type="date" id="date" name="endDate" value="${endDate != null ? endDate : '2022-01-10'}"/>	
						</div>
						<div>
						
							<input type="checkbox" name="isPriceSearch" value = "true" <c:if test="${isPriceSearch == 'true'}">checked=checked</c:if>>
							<label>max Price per Day</label>
							<input type="text" id="price" name="maxPrice" value="${maxPrice != null ? maxPrice : ''}"/>
						</div>
						<div>
							
							<input type="checkbox" name="isCategorySearch" value="true" <c:if test="${isCategorySearch == 'true'}">checked=checked</c:if>>
							<label>category</label>
							<select name="category" id="keyword">
								<c:forEach items="${categories}" var="cat">
									<option value="${cat.title}" ${cat.title == category ? 'selected' : ''}> ${cat.title}</option>				
								</c:forEach>
							</select>
						</div>
					</div> 
			</form>
		</section>
		
		<br/> <br/> 


		<c:forEach items="${products}" var="product">
			<div id="search"
				onclick="location.href='/details/${product.productId}';"
				style="cursor: pointer;">

				<div class="search">
					<h3>${product.title}</h3>
					<img src="/product-pictures/${product.getPictures()[0].getName()}"
						alt="${product.title}">
				</div>


				<div class="search">
					<h4>Price/day : ${product.pricePerDay}</h4>
					<p>${product.description}</p>

				</div>
			</div>
		</c:forEach>

	</div>

	<footer>
		<div class="wrapper">
			<div class="footer">
				<a class="icon" href="/">&#127968;</a> <a class="icon" id="up"
					href="/upload">&#10144;</a> <a class="icon" href="/profile">&#128587;</a>
				<a class="icon" href="/">&#9881;</a>
			</div>
		</div>
	</footer>

	<script src="https://unpkg.com/scrollreveal"></script>
	<script src="/js/main.js"></script>
</body>
</html>