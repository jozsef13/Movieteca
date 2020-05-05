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
<link rel="stylesheet" href="/fonts/icomoon/style.css">

<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/magnific-popup.css">
<link rel="stylesheet" href="/css/jquery-ui.css">
<link rel="stylesheet" href="/css/owl.carousel.min.css">
<link rel="stylesheet" href="/css/owl.theme.default.min.css">


<link rel="stylesheet" href="/css/aos.css">

<link rel="stylesheet" href="/css/style.css">

</head>
<div class="site-wrap">
	<header class="site-navbar" role="banner">
	<div class="site-navbar-top">
		<div class="container">
			<div class="row align-items-center">

				<div
					class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
					<div class="site-logo">
						<a href="/" class="js-logo-clone">MOVIETECA</a>
					</div>
				</div>

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<li><a href="/myaccount.jsp"><span class="icon icon-person"></span></a></li>
							<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
							<li><a href="/cart/<c:out value = "${cart.id}" />"
								class="site-cart"> <span class="icon icon-shopping_cart"></span>
								<span class="count"> 
									<c:choose>
										<c:when test="${empty cart}">
											0
										</c:when>
										<c:otherwise>
											<c:out value="${cart.moviesInCart.size()}" />
										</c:otherwise>
									</c:choose>
								</span>
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
			<li class="nav-item"><a href="/">Home</a></li>
			<li class="nav-item"><a href="/movies">Movies</a></li>
			<li class="nav-item"><a href="/contact">Contact</a></li>
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

	<div class="site-blocks-cover"
		style="background-image: url(images/background.jpg);" data-aos="fade">
		<div class="container">
			<div
				class="row align-items-start align-items-md-center justify-content-end">
				<div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
					<h1 style="color: white;">Best Seller</h1>
					<div class="intro-text text-center text-md-left">
						<p style="color: white;">Check out our best seller last month
							at an amazing price. Have your own cinema at home.</p>
						<p>
							<a href="/movie/<c:out value = "${movie.id}"/>" class="btn btn-sm btn-primary">Buy now</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="site-section">
		<div class="container">
			<div class="row mb-5">
				<c:forEach items="${movies}" var="singleMovie">
					<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
						<div class="block-4 text-center border">
							<figure class="block-4-image"> <a href="/movie/<c:out value = "${singleMovie.id}"/>"><img
								style="width: 500px; height: 300px;" src="<c:out value="${singleMovie.imagePath}" />"
								alt="Image placeholder" class="img-fluid"></a> </figure>
							<div class="block-4-text p-4">
								<h3>
									<a href="/movie/<c:out value = "${singleMovie.id}"/>"><c:out value = "${singleMovie.name}"/></a>
								</h3>
								<br>
								<p align="left">Running time: <c:out value = "${singleMovie.playTime}"/></p>
								<p align="left">Starring: <c:out value = "${singleMovie.mainActors}"/></p>
								<p align="left">Genre: <c:out value = "${singleMovie.genre}"/></p>
								<p align="left" class="mb-0 rated">
									<span>Rating: </span> <span class="fa fa-star checked"></span> <span
										class="fa fa-star checked"></span> <span
										class="fa fa-star checked"></span> <span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="site-section site-section-sm site-blocks-1">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="">
						<div class="icon mr-4 align-self-start">
							<span class="icon-truck"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Free Shipping</h2>
							<p>You can benefit for free shipping for a short period of
								time. Grab a movie and lay back. We'll deliver it to you for
								free.</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="100">
						<div class="icon mr-4 align-self-start">
							<span class="icon-refresh2"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Free Returns</h2>
							<p>If you don't feel like you want that movie anymore, you
								can return it for free. Keep in mind that the product must be
								sealed and not damaged.</p>
						</div>
					</div>
					<div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4"
						data-aos="fade-up" data-aos-delay="200">
						<div class="icon mr-4 align-self-start">
							<span class="icon-help"></span>
						</div>
						<div class="text">
							<h2 class="text-uppercase">Customer Support</h2>
							<p>We are here for you! Do you have any question about buying
								or renting from us? Don't hesitate to contact us at our contact
								page.</p>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>


<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery-ui.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/aos.js"></script>

<script src="/js/main.js"></script>

</body>
</html>
