<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script>var today = new Date().toISOString().split('T')[0];
console.log(today)</script>

<title>Details</title>



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
				<input class="search-bar" type="text" name="keyword"
					placeholder="&#128269 Search Items" /> <input type="submit"
					class="button_active" value="Submit" value="/search" />
			</form>
		</section>

		<section id="detail-page">
			<div id="details">
				<div class="details">
					<h2>${product.title}</h2>
					<c:forEach items="${product.getPictures()}" var="picture">

						<img src="/product-pictures/${picture.getName()}" alt="">
					</c:forEach>
				</div>

				<div class="details">
					<h3>Price/day : ${product.pricePerDay}</h3>
					<h4>${product.description}</h4>

				</div>

				<c:choose>
					<c:when
						test="${product.requestproduct != true and user.username != product.getOwnerUsername()}">
						<p>This item is available</p>

						<form method="Post" action="/details/${product.productId}">
							<br></br> <input type=hidden value="${Product.productId}" /> <Label>Start
								Date</Label> <input type=date placeholder="value" name="startDate" min="${today}" required/> <br />
							<Label>End Date</Label> <input type=date placeholder="Value"
								name="endDate" /> <br></br> <input class="book" type="submit"
								value="BOOK ITEM" required/>
						</form>

						<br></br>
					</c:when>

					<c:when
						test="${product.requestproduct == true and user.username == product.getBorrowerUsername() and product.acceptrequest == false}">
						<p>You have sent a request for this item</p>
					</c:when>

					<c:when
						test="${product.requestproduct != true and user.username == product.getOwnerUsername()}">
						${rejected}
						<p>This item belongs to you, try another one</p>
					</c:when>

					<c:when
						test="${product.requestproduct == true and user.username == product.getOwnerUsername() and product.acceptrequest == false}">
						<p>${product.getBorrowerUsername()}has requested your item:
							${product.title}!</p>
						<p>Between the ${product.getStartDate()} and the
							${product.getEndDate()}</p>
						<br></br>
						<form method="Post" action="/details/${product.productId}">
							<Label>Do you accept these terms?</Label> <br />
							<input type="submit" value="YES" name="acceptRequest" /> <input
								type=hidden type=date value="${product.getStartDate()}"
								name="startDate" /> <input type=hidden type=date
								value="${product.getEndDate()}" name="endDate" />
						</form>

						<form method="Post" action="/details/no/${product.productId}">
						<input  type="submit" value="NO" name="denyRequest"/>
						</form>	
					</c:when>

					<c:when
						test="${product.acceptrequest == true and user.username == product.getOwnerUsername()}">
						<p>You have successfully lent the item!</p>
					</c:when>
					<c:when
						test="${product.acceptrequest == true and user.username != product.getOwnerUsername() and user.username != product.getBorrowerUsername()}">
						<p>This item is currently in possession of a another user</p>
					</c:when>

					<c:when
						test="${product.acceptrequest == true  and user.username == product.getBorrowerUsername()}">
						<p>Congratulations, you got the item!!!</p>
						Talk and communicate with ${product.getOwnerUsername()} to organise collection of your item.
						
					</c:when>

					<c:otherwise>
						<p>This item is not available</p>
					</c:otherwise>
				</c:choose>

				<br></br> <a id="talk" href="/chats/${product.getOwnerUsername()}">Chat
					with the owner</a> <br></br>
		</section>
		<br></br>

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