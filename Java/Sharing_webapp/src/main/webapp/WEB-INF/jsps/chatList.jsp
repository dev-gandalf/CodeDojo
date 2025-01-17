<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Chats</title>

<link rel="stylesheet" href="/css/style.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans:wght@400;700&display=swap"
	rel="stylesheet" />

<!-- <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script src="/js/scripts.js"></script>

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

		<section id="all-chats">

			<c:forEach items="${allChats}" var="chat">

				<div id="indivilual-chat">
					<a id="naked-link" href="/chats/${chat}"><div>
							Your messages with the user:
							<h2>${chat}</h2>
						</div></a>
				</div>

			</c:forEach>

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