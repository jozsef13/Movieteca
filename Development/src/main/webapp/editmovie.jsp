<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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

				<div class="col-7 col-md-7 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<security:authorize access="hasAnyRole('Customer')">
									<security:authentication property="principal.user.cart"
										var="cart" />
									<li><c:choose>
											<c:when test="${empty cart}">
											<a href="#" class="site-cart">
												<button class="btn btn-secondary btn-sm site-cart">
													<span class="icon icon-shopping_cart"></span> <span
														class="count"> 0 </span>
												</button>
												</a>
											</c:when>
											<c:when test="${not empty cart}">
												<a href="/cart/<c:out value = "${cart.id}" />"
													class="site-cart">
													<button class="btn btn-secondary btn-sm">
														<span class="icon icon-shopping_cart"></span> <span
															class="count"> <c:out
																value="${cart.moviesInCart.size()}" />
														</span>
													</button>
												</a>
											</c:when>
										</c:choose></li>
								</security:authorize>
							<li>
								<div class="btn-group">
										<button class="btn btn-secondary btn-sm"
											onclick="myFunction()" type="button">
											<span class="icon icon-person"></span>
										</button>
										<button type="button"
											class="btn btn-sm btn-secondary dropdown-toggle dropdown-toggle-split"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<span class="sr-only">Toggle Dropdown</span>
										</button>

										<security:authorize access="!isAuthenticated()">
											<div class="dropdown-menu">
												<a class="dropdown-item" href="/login">Login</a> <a
													class="dropdown-item" href="/register">Register</a>
											</div>
										</security:authorize>
										<security:authorize access="isAuthenticated()">
											<div class="dropdown-menu">
												<a class="dropdown-item" href="/myaccount">My Account</a> 
												<a class="dropdown-item" href="/logout">Logout</a>
											</div>
										</security:authorize>
									</div>
							</li>
							<li class="d-inline-block d-md-none ml-md-0"><a href="#"
								class="site-menu-toggle js-menu-toggle"><span
									class="icon-menu"></span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<nav class="site-navigation text-right text-md-center" role="navigation">
	<div class="container" style="margin-left: 300px">
		<ul class="site-menu js-clone-nav d-none d-md-block">
			<li class="nav-item"><a href="/">Home</a></li>
			<li class="nav-item"><a href="/movies">Movies</a></li>
			<li class="nav-item"><a href="/contact">Contact</a></li>
			<li
				class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
				<form action="/movies/search" class="site-block-top-search">
					<span class="icon icon-search2"></span> <input type="text"
						class="form-control border-0" placeholder="Search.."
						name="nameString">
				</form>
			</li>
		</ul>
	</div>
	</nav> </header>

		<div class="bg-light py-3">
			<div class="container">
				<div class="row">
					<div class="col-md-12 mb-0">
						<a href="/">Movies</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Add Movie</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<form action="/addMovie" method="post" enctype = "multipart/form-data">
					<div class="row">
						<div class="col-md-6">
							<p>
								<b>Movie Title:</b> <input type="text" class="form-control"
									id="c_fname" name="name">
							</p>
							<p>
								<b>Upload Image:</b> <input type="file" class="form-control"
									id="img" name="img">
							</p>
							<p>
								<b>Release Date:</b> <input type="date" class="form-control"
									id="c_fname" name="releaseDate">
							</p>
							<p>
								<b>Running Time:</b> <input type="text" class="form-control"
									id="c_fname" name="playTime">
							</p>
							<p>
								<b>Genre:</b> <input type="text" class="form-control" id="c_fname"
									name="genre">
							</p>
							<p>
								<b>Directed By:</b> <input type="text" class="form-control"
									id="c_fname" name="directors">
							</p>
							<p>
								<b>Produced By:</b> <input type="text" class="form-control"
									id="c_fname" name="witers">
							</p>
							<p>
								<b>Description:</b> <input type="text" class="form-control"
									id="c_fname" name="description">
							</p>
							<p>
								<b>Imdb:</b> <input type="text" class="form-control" id="c_fname"
									name="iMDbRating">
							</p>
							<p>
								<b>Starring:</b> <input type="text" class="form-control" id="c_fname"
									name="mainActors">
							</p>
							<p>
								<b>Trailer Link:</b> <input type="text" class="form-control"
									id="c_fname" name="trailerLink">
							</p>
							<p>
								<b>Rent Price:</b> <input type="text" class="form-control" id="c_fname"
									name="rentPrice">
							</p>
							<p>
								<b>Buy Price:</b> <input type="text" class="form-control" id="c_fname"
									name="buyPrice">
							</p>

							<div class="mb-5">

								<b>Stock:</b>
								<div class="input-group mb-3" style="max-width: 120px;">
									<div class="input-group-prepend">
										<button class="btn btn-outline-primary js-btn-minus"
											type="button">&minus;</button>
									</div>
									<input type="text" class="form-control text-center" value="1"
										placeholder="" aria-label="Example text with button addon"
										aria-describedby="button-addon1" name="stock">
									<div class="input-group-append">
										<button class="btn btn-outline-primary js-btn-plus"
											type="button">&plus;</button>
									</div>
								</div>
								<input type="submit" class="buy-now btn btn-sm btn-primary"
									value="Add Movie">
							</div>
						</div>

					</div>
				</form>
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
<script>
		function myFunction() {
			location.href = "/myaccount"
		};
	</script>
</body>
</html>
