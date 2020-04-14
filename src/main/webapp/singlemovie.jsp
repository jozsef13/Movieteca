<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>MOVIETECA</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">


<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<div class="site-wrap">
		<header class="site-navbar" role="banner">
		<div class="site-navbar-top">
			<div class="container">
				<div class="row align-items-center">

					<div
						class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
						<div class="site-logo">
							<a href="index.jsp" class="js-logo-clone">MOVIETECA</a>
						</div>
					</div>

					<div class="col-6 col-md-4 order-3 order-md-3 text-right">
						<div class="site-top-icons">
							<ul>
								<li><a href="/provider/1"><span class="icon icon-person"></span></a></li>
								<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
								<li><a href="cart.jsp" class="site-cart"> <span
										class="icon icon-shopping_cart"></span> <span class="count">0</span>
								</a></li>
								<li class="d-inline-block d-md-none ml-md-0"><a href="#"
									class="site-menu-toggle js-menu-toggle"><span
										class="icon-menu"></span></a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>

		<nav class="site-navigation text-right text-md-center"
			role="navigation">
		<div class="container">
			<ul class="site-menu js-clone-nav d-none d-md-block">
				<li class="nav-item"><a href="index.jsp">Home</a></li>
				<li class="nav-item"><a href="movies.jsp">Movies</a></li>
				<li class="nav-item"><a href="contact.jsp">Contact</a></li>
				<li
					class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="" class="site-block-top-search">
						<span class="icon icon-search2"></span> <input type="text"
							class="form-control border-0" placeholder="Search">
					</form>
				</li>
			</ul>
		</div>
		</nav> </header>

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="index.jsp">Movies</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Movie Genre</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<h2 class="text-black">${movie.name}</h2>
				<div class="row">
					<img style="width: 500px; height: 600px;" src="images/movie.jpg">
					<div class="col-md-6">

						<p>Release Date: ${movie.releaseDate}</p>
						<p>Running Time: ${movie.playTime}</p>
						<p>Genre: ${movie.genre}</p>
						<p>Directed By: ${movie.directors}</p>
						<p>Produced By: ${movie.witers}</p>
						<p>Production Company: ${movie.provider.firstName}</p>
						<p>Starring: ${movie.mainActors}</p>
						<p>
							Trailer Link: <a href="${movie.trailerLink}"> Click here </a>
						</p>
						<p>
							<strong class="text-primary h4"> ${movie.rentPrice} /
								${movie.buyPrice}</strong>
						</p>
						<div class="mb-1 d-flex">
							<label for="option-sm" class="d-flex mr-3 mb-3"> <span
								class="d-inline-block mr-2"
								style="top: -2px; position: relative;"><input
									type="radio" id="option-sm" name="RENT"></span> <span
								class="d-inline-block text-black">Rent</span>
							</label> <label for="option-md" class="d-flex mr-3 mb-3"> <span
								class="d-inline-block mr-2"
								style="top: -2px; position: relative;"><input
									type="radio" id="option-md" name="BUY"></span> <span
								class="d-inline-block text-black">Buy</span>
							</label>
						</div>
						<div class="mb-5">
							<div class="input-group mb-3" style="max-width: 120px;">
								<div class="input-group-prepend">
									<button class="btn btn-outline-primary js-btn-minus"
										type="button">&minus;</button>
								</div>
								<input type="text" class="form-control text-center" value="1"
									placeholder="" aria-label="Example text with button addon"
									aria-describedby="button-addon1">
								<div class="input-group-append">
									<button class="btn btn-outline-primary js-btn-plus"
										type="button">&plus;</button>

								</div>
							</div>
							<p>
								<a href="cart.jsp" class="buy-now btn btn-sm btn-primary">Add
									To Cart</a>
							</p>
							<p>
								Sold by: <a class="d-flex color-item align-items-center"> <span
									class="bg-success color d-inline-block rounded-circle mr-2"></span>
									<span class="text-black">On stock</span>
								</a>
							</p>
						</div>
					</div>
				</div>
				<p class="mb-3 h5 text-uppercase text-black d-block">MOVIE
					DESCRIPTION</p>
				<p>${movie.description}</p>
			</div>
		</div>

		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Similar Movies</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image"> <img
										src="images/movie.jpg" alt="Image placeholder"
										class="img-fluid"> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Similar movie 1</a>
										</h3>
										<p class="mb-0">short description</p>
										<p class="text-primary font-weight-bold">Price: $5/$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image"> <img
										src="images/movie.jpg" alt="Image placeholder"
										class="img-fluid"> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Similar movie 2</a>
										</h3>
										<p class="mb-0">short description</p>
										<p class="text-primary font-weight-bold">Price: $5/$50</p>
									</div>
								</div>
							</div>
							<div class="item">
								<div class="block-4 text-center">
									<figure class="block-4-image"> <img
										src="images/movie.jpg" alt="Image placeholder"
										class="img-fluid"> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="#">Similar movie 2</a>
										</h3>
										<p class="mb-0">short description</p>
										<p class="text-primary font-weight-bold">Price: $5/$50</p>
									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-ui.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>

	<script src="js/main.js"></script>

</body>
</html>
