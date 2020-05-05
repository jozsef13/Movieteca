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
<body>

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
								<li><a href="/myaccount.jsp"><span
										class="icon icon-person"></span></a></li>
								<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
								<li><a href="/cart/<c:out value = "${cart.id}" />"
									class="site-cart"> <span class="icon icon-shopping_cart"></span>
										<span class="count"> <c:choose>
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
				<li class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
					<form action="/movies/search" class="site-block-top-search">
						<span class="icon icon-search2"></span> 
						<input type="text" class="form-control border-0" placeholder="Search.." name="nameString">
					</form>
				</li>
			</ul>
		</div>
		</nav> </header>
		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Login</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-3 text-black">Login here</h2>
					</div>
					<div class="col-md-7">

						<form action="#" method="post">

							<div class="p-3 p-lg-5 border">
								<div class="form-group column">
									<div class="col-md-6">
										<label for="c_fname" class="text-black"><b> User
												Type </b><br>
											<form action="">
												<input type="radio" name="usertype" value="customer"
													checked="checked"> Customer <input type="radio"
													name="usertype" value="provider"> Provider<br>
											</form> </label>
									</div>
									<div class="col-md-6">
										<label for="c_fname" class="text-black"> <b>
												Username </b></label> <input type="text" class="form-control"
											id="c_fname" name="c_fname">
									</div>
									<div class="col-md-6">
										<label for="c_lname" class="text-black"> <b>
												Password </b></label> <input type="password" class="form-control"
											id="c_lname" name="c_lname">
									</div>
								</div>

								<label> <input type="checkbox" name="remember">
									Remember me
								</label>


								<div class="col-md-6">
									<a href="#"><span class="psw">Forgot my
											username/password</a></span>
								</div>
								<br>

								<div class="col-lg-13">
									<input type="submit" class="btn btn-primary btn-lg btn-block"
										value="LOG IN! ">
								</div>

							</div>
						</form>
					</div>
					<div class="col-md-5 ml-auto">
						<br> <br> <br> <a href="/signup.jsp"
							class="btn btn-primary btn-lg btn-block">Don't have an
							account?</a>
						<div class="col-lg-12"></div>

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
