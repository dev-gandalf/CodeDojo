<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Upload</title>

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


		<section id="upload">
			<div style="color: red;">${confirmation}</div>
			<form class="upload" method="POST" enctype="multipart/form-data"
				action="/upload">
				<label>Product Name</label> <input type="text" id="product-name"
					name="product" value="" autocomplete="off" required /> <br /> <label>Price
					per day in Euros</label> <input type="number" id="product-name"
					name="price" value="" autocomplete="off" required
					placeholder="ex: 10  or 10.38" /> <br /> <label>Product
					description</label>
				<textarea rows="5" cols="50" class="description" name="description"
					size="150" placeholder="max 150 words" value="" autocomplete="off"
					required></textarea>
				<br /> <label for="keyword-select">Product Category:</label> <select
					name="keyword" id="keyword">
					<c:forEach items="${categories}" var="category">
						<option value="${category.title}">${category.title}</option>
					</c:forEach>
				</select> <br />


				<div class="center-input">
					<div class="container">
						<div class="wrap-inputs">
							<p>Add more pictures</p>
							<a href="upload" class="add"> &plus;
							</a>
						</div>
						<div class="input-group">
							<label for="files">Select a main picture <br/>(max 3MB per picture)</label> <input
								type="file" id="files" class="first-input" name="file"
								accept="image/jpeg, image/png, image/jpg" required />
						</div>
					</div>
				</div>

				<br /> <input type="submit" value="Upload" />
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
	<script>
		if (window.history.replaceState) {
			window.history.replaceState(null, null, window.location.href);
		}
	</script>
	<script src="/js/main.js"></script>

</body>
</html>