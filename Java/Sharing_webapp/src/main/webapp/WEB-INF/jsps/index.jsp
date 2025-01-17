<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Shazar</title>

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

		<section id="home">
			<div class="wrapper home">

				<div class="col-a">
					<img src="/pictures/bike.jpg" alt="An older racing bike" />
				</div>


				<div class="col-b">
					<img src="/pictures/bed.jpg"
						alt="A king size bed covered with sheets and pillows" />
				</div>


				<div class="col-a">
					<img src="/pictures/car.jpg" alt="A white bugati" />
				</div>

				<div class="col-b">
					<img src="/pictures/ventilator.jpg" alt="A purple-red ventilator" />
				</div>


				<div class="col-a">
					<img src="/pictures/type-writer.jpg"
						alt="An old beige type-writer." />
				</div>

				<div class="col-b">
					<img src="/pictures/lawn-mower.jpg"
						alt="A black lawn-mover on the green grass" />
				</div>
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
	<script src="/js/main.js"></script>
</body>
</html>