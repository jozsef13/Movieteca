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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
												<a class="dropdown-item" href="/myaccount">My Account</a> <a
													class="dropdown-item" href="/logout">Logout</a>
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

		<nav class="site-navigation text-right text-md-center"
			role="navigation">
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
					<c:if test="${not empty errorMessage }">
						<div class="row mb-5" id="error">
							<div class="col-md-12">
								<div class="border p-4 rounded" role="alert"
									style="text-align: center">
									<p>
										<c:out value="${errorMessage }"></c:out>
									</p>
								</div>
							</div>
						</div>
					</c:if>
					<div class="col-md-12 mb-0">
						<a href="/movies">Movies</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">${movie.genre}</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="site-section">
			<div class="container">
				<h2 class="text-black">${movie.name}</h2>
				<div class="row">
					<div class="col-md-6">
						<img style="width: 500px; height: 600px;"
							src="<c:out value="${movie.imagePath}" />"> <br> <br>
						<h3 class="mb-3 text-uppercase text-black d-block">MOVIE
							DESCRIPTION:</h3>
						<p>${movie.description}</p>
					</div>
					<div class="col-md-6">
						<p style="font-size: 16px">
							<b>Release Date:</b> ${movie.releaseDate}
						</p>
						<p style="font-size: 16px">
							<b>Running Time:</b> ${movie.playTime}
						</p>
						<p style="font-size: 16px">
							<b>Genre:</b> ${movie.genre}
						</p>
						<p style="font-size: 16px">
							<b>Directed By:</b> ${movie.directors}
						</p>
						<p style="font-size: 16px">
							<b>Produced By:</b> ${movie.witers}
						</p>
						<p style="font-size: 16px">
							<b>Starring:</b> ${movie.mainActors}
						</p>
						<p style="font-size: 16px">
							<b>Trailer Link:</b> <a href="${movie.trailerLink}"> Click
								here </a>
						</p>
						<p>
							<b>iMDb rating: </b>${movie.iMDbRating }
						</p>
						<p>
							<b>Average rating: </b>${movie.averageRating }
							<c:choose>
								<c:when test="${movie.averageRating <= 0 }">
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 1 and movie.averageRating < 2 }">
									<span class="fa fa-star-half checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 2 and movie.averageRating < 3 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 3 and movie.averageRating < 4 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star-half checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 4 and movie.averageRating < 5 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 5 and movie.averageRating < 6 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star-half checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 6 and movie.averageRating < 7 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 7 and movie.averageRating < 8 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star-half checked"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 8 and movie.averageRating < 9 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star"></span>
								</c:when>
								<c:when
									test="${movie.averageRating > 9 and movie.averageRating < 10 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star-half checked"></span>
								</c:when>
								<c:when test="${movie.averageRating >= 10 }">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
								</c:when>
							</c:choose>
						</p>
						<p style="font-size: 16px">
							<strong class="text-primary h4"> ${movie.rentPrice}$ /
								${movie.buyPrice}$</strong>
						</p>
						<p style="font-size: 16px">
							<b>Sold by: <a
								href="/user/<c:out value="${movie.provider.id}"/>"><c:out
										value="${movie.provider.userName }"></c:out></a></b>
						</p>
						<security:authorize access="hasAnyRole('Customer')">
							<p>
								<c:choose>
									<c:when test="${movie.stock > 10 }">
										<p class="d-flex color-item align-items-center">
											<span
												class="bg-success color d-inline-block rounded-circle mr-2"></span>
											<span class="text-black">On stock</span>
										</p>
									</c:when>
									<c:when test="${movie.stock <= 10 and movie.stock > 0 }">
										<p class="d-flex color-item align-items-center">
											<span
												class="bg-warning color d-inline-block rounded-circle mr-2"></span>
											<span class="text-black">Few left</span>
										</p>
									</c:when>
									<c:when test="${movie.stock eq 0 }">
										<p class="d-flex color-item align-items-center">
											<span
												class="bg-danger color d-inline-block rounded-circle mr-2"></span>
											<span class="text-black">Not on stock</span>
										</p>
									</c:when>
								</c:choose>
							</p>
							<c:choose>
								<c:when test="${movie.stock > 0 }">
									<form action="/addToCart/Movie/<c:out value="${movie.id}" />">
										<div class="mb-1 d-flex">
											<input type="radio" value="Buy" name="orderType"
												checked="checked"><label for="male">Buy</label> <input
												type="radio" value="Rent" name="orderType"><label
												for="male">Rent</label>
										</div>
										<div class="mb-5">
											<div class="input-group mb-3" style="max-width: 120px;">
												<div class="input-group-prepend">
													<button class="btn btn-outline-primary js-btn-minus"
														type="button">&minus;</button>
												</div>
												<input type="text" class="form-control text-center"
													value="1" placeholder=""
													aria-label="Example text with button addon"
													aria-describedby="button-addon1" name="orderQuantity">
												<div class="input-group-append">
													<button class="btn btn-outline-primary js-btn-plus"
														type="button">&plus;</button>
												</div>
											</div>
										</div>
										<div class="col-md-5"
											style="display: inline-block; text-align: left;">
											<input style="display: inline-block;" type="submit"
												class="btn btn-primary btn-lg btn-block" value="Add to cart">
										</div>
										<div class="col-md-5" style="display: inline-block">
											<a href="/movie/addReviewPage/<c:out value="${movie.id }"/>"
												class="btn btn-primary btn-lg btn-block">Add review</a>
										</div>
									</form>
								</c:when>
								<c:otherwise>
									<form action="/addToCart/Movie/<c:out value="${movie.id}" />">
										<div class="mb-1 d-flex">
											<input type="radio" value="Buy" name="orderType" disabled><label
												for="male">Buy</label> <input type="radio" value="Rent"
												name="orderType" disabled><label for="male">Rent</label>
										</div>
										<div class="mb-5">
											<div class="input-group mb-3" style="max-width: 120px;">
												<div class="input-group-prepend">
													<button class="btn btn-outline-primary js-btn-minus"
														type="button" disabled>&minus;</button>
												</div>
												<input type="text" class="form-control text-center"
													value="1" placeholder=""
													aria-label="Example text with button addon"
													aria-describedby="button-addon1" name="orderQuantity">
												<div class="input-group-append" disabled>
													<button class="btn btn-outline-primary js-btn-plus"
														type="button" disabled>&plus;</button>
												</div>
											</div>
										</div>
										<br>
										<div class="col-md-5"
											style="display: inline-block; text-align: right;">
											<input style="display: inline-block;" type="submit"
												class="btn btn-primary btn-lg btn-block" value="Add to cart">
										</div>
									</form>
								</c:otherwise>
							</c:choose>
						</security:authorize>
						<security:authorize access="hasAnyRole('Provider', 'Admin')">
							<p style="font-size: 16px">
								<b>Stock: <c:out value="${movie.stock }"></c:out></b>
							</p>
							<security:authorize access="hasRole('Provider')">
								<security:authentication property="principal.username"
									var="providerName" />
								<c:if test="${movie.provider !=  providerName}">
									<a href="/movie/editPage/<c:out value="${movie.id }"/>"
										class="buy-now btn btn-sm btn-primary">Edit</a>
								</c:if>
							</security:authorize>
							<security:authorize access="hasRole('Admin')">
								<a href="/movie/editPage/<c:out value="${movie.id }"/>"
									class="buy-now btn btn-sm btn-primary">Edit</a>
							</security:authorize>
						</security:authorize>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section block-3 site-blocks-2 bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 site-section-heading text-center pt-4">
						<h2>Reviews</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="nonloop-block-3 owl-carousel">
							<c:forEach items="${movie.reviewsReceived}" var="review">
								<div class="item">
									<div class="block-4">
										<div class="block-4-text p-2">
											<b>User: </b><a
												href="/user/<c:out value="${review.customer.id}"/>"><c:out
													value="${review.customer.userName }"></c:out></a>
										</div>
										<div class="block-4-text p-2">
											<b>Rating: </b>
											<c:out value="${review.rating }"></c:out>
										</div>
										<div class="block-4-text p-2">
											<b>Review: </b>
											<c:out value="${review.reviewText }"></c:out>
										</div>
										<div class="block-4-text p-2">
											<b><a href="/contact">Report user</a></b>
										</div>
									</div>
								</div>
							</c:forEach>
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
	<script>
		function myFunction() {
			location.href = "/myaccount"
		};
	</script>
	<script>
		var fade_out = function() {
			$("#error").fadeOut().empty();
		}

		setTimeout(fade_out, 5000);
	</script>
</body>
</html>
