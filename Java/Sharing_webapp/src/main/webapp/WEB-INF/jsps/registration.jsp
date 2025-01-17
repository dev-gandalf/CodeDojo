<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Registration</title>

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

		<section id="registration">
			<div id="navigate">
				<p>
					Already have an account? <a href="/login">Login</a>
				</p>

				<div style="color: red;">${emailMessage}</div>
				<div style="color: red;">${userNameMessage}</div>
				<div style="color: red;">${passwordMessage}</div>
			</div>
			<form method="post" action="/registration">
				<div id="sign-up">
					<div class="sign-up">
						<label>First Name</label> <input type="text" id="first"
							name="firstName" placeholder="" value="" autocomplete="off"
							required /> <br /> <label>Username</label> <input type="text"
							id="user" name="username" placeholder="" value=""
							autocomplete="off" required /> <br /> <label>Password</label> <input
							type="password" id="password" name="password" minlength="8"
							placeholder="" value="" autocomplete="off" required /> <br /> <label>Street</label>
						<input type="text" id="street" name="streetName" placeholder=""
							value="" autocomplete="off" required /> <br /> <label>Zip
							Code</label> <input type="text" id="zip-code" name="zipCode"
							placeholder="" value="" autocomplete="off" required />

					</div>

					<div class="sign-up">

						<br /> <label>Last Name</label> <input type="text" id="last"
							name="lastName" placeholder="" value="" autocomplete="off"
							required /> <br /> <label>Email Address</label> <input
							type="email" id="email"
							pattern="[^@\\\\\\\\\s]+@[^@\s]+\.[^@\s]+" name="email"
							placeholder="" value="" autocomplete="off" required /> <br /> <label>Confirm
							Password</label> <input type="password" id="password"
							name="passwordConfirmed" minlength="8" placeholder="" value=""
							autocomplete="off" required /> <br /> <label>City</label> <input
							type="text" id="city" name="cityName" placeholder="" value=""
							autocomplete="off" required /> <br /> <label>Country</label> <input
							type="text" id="country" name="country" placeholder="" value=""
							autocomplete="off" required /> <br />
					</div>
				</div>
				<br /> <br />
				<div>
					<button type="submit" value="/registration">Register</button>
				</div>

			</form>
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
	<script src="/js/main.js"></script>
</body>
</html>