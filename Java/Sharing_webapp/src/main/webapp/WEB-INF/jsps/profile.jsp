<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Profile</title>

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

		<section id="profile">
			<div id="profile-wrapper">
				<h2>Welcome ${user.getUsername()}</h2>
				<h3>Your Personal Information</h3>
				<div>
					<p>First Name: ${user.getFirstName()}</p>
					<p>Last Name: ${user.getLastName()}</p>
					<p>Zip Code: ${user.getZipCode()}</p>
					<p>City: ${user.getCityName()}</p>
					<p>Country: ${user.getCountry()}</p>

					<br /> <a href="/logout">logout</a> <br /> <br />
				</div>
			</div>

			<br />
			<hr>
			<br />
			<div>
				<h4>Update your information</h4>
				<br />
				<form method="POST" action="/profile" class="info-wrapper">

					<input type="hidden" name="username" readonly="readonly"
						value="${user.getUsername()}" /> <label> First Name:</label> <input
						type="text" name="firstName" value="${user.getFirstName()}" /> <label>
						Last Name:</label> <input type="text" name="lastName"
						value="${user.getLastName()}" /> <label> Zip Code:</label> <input
						type="text" name="zipCode" value="${user.getZipCode()}" /> <label>
						City:</label> <input type="text" name="cityName"
						value="${user.getCityName()}" /> <label> Country:</label> <input
						type="text" name="country" value="${user.getCountry()}" /> <br />
					<input type="submit" class="button_active" value="Update" />
				</form>

			</div>
		</section>

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
	<script>
		if (window.history.replaceState) {
			window.history.replaceState(null, null, window.location.href);
		}
	</script>
	<script src="/js/main.js"></script>
</body>
</html>