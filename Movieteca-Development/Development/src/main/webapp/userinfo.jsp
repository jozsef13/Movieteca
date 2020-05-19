<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<div class="col-md-12 mb-0">
						<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black"><c:out value="${user.userName }"></c:out>'s
							Info </strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<c:if test="${not empty errorMessage }">
					<div class="row mb-12" id="error">
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
				<div class="row">

					<div class="col-md-5">
						<img style="width: 350px; height: 300px;"
							src="<c:out value="${user.profilePicture }"/>"
							alt="Image placeholder" class="img-fluid">
					</div>
					<div class="col-md-6">
						<u><h2 class="text-black">
								<c:out value="${user.userName }"></c:out>
								's Profile
							</h2></u>
						<p>
							First Name:
							<c:out value="${user.firstName }"></c:out>
						</p>
						<p>
							Last Name:
							<c:out value="${user.lastName }"></c:out>
						</p>
						<p>
							E-Mail:
							<c:out value="${user.email }"></c:out>
						</p>
						<c:if test="${user.userType eq 'Provider' }">
							<p>
								Rating:
								<c:out value="${user.averageRating }" />
								<c:choose>
									<c:when test="${user.averageRating <= 0 }">
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 1 and user.averageRating < 2 }">
										<span class="fa fa-star-half checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 2 and user.averageRating < 3 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 3 and user.averageRating < 4 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star-half checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 4 and user.averageRating < 5 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 5 and user.averageRating < 6 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star-half checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 6 and user.averageRating < 7 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 7 and user.averageRating < 8 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star-half checked"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 8 and user.averageRating < 9 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star"></span>
									</c:when>
									<c:when
										test="${user.averageRating > 9 and user.averageRating < 10 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star-half checked"></span>
									</c:when>
									<c:when test="${user.averageRating >= 10 }">
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
										<span class="fa fa-star checked"></span>
									</c:when>
								</c:choose>
							</p>
						</c:if>
					</div>
				</div>
				<br>
				<security:authorize access="isAuthenticated()">
					<security:authorize access="hasRole('Customer')">
						<c:if test="${user.userType eq 'Provider' }">
							<div class="col-md-5" style="display: inline-block">
								<a href="/sendMessage/<c:out value="${user.id }" />"
									class="buy-now btn btn-sm btn-primary">Send Private Message</a>
							</div>
						</c:if>
					</security:authorize>
					<security:authorize access="hasRole('Provider')">
						<c:if test="${user.userType eq 'Customer'}">
							<div class="col-md-5" style="display: inline-block">
								<a href="/sendMessage/<c:out value="${user.id }" />"
									class="buy-now btn btn-sm btn-primary">Send Private Message</a>
							</div>
						</c:if>
					</security:authorize>
					<security:authorize access="hasRole('Admin')">
						<c:if test="${user.active eq true }">
							<div class="col-md-5" style="display: inline-block">
								<a href="/user/ban/<c:out value="${user.id }"/>"
									class="buy-now btn btn-sm btn-primary">Ban user</a>
							</div>
						</c:if>

						<c:if test="${user.active eq false }">
							<div class="col-md-5" style="display: inline-block">
								<a href="/user/activateAccount/<c:out value="${user.id }"/>"
									class="buy-now btn btn-sm btn-primary">Activate user</a>
							</div>
						</c:if>

					</security:authorize>
				</security:authorize>
				<div class="col-md-5" style="display: inline-block">
					<c:if test="${user.userType eq 'Provider' }">
						<security:authorize access="hasRole('Customer')">
							<a href="/provider/addReviewPage/<c:out value="${user.id }"/>"
								class="buy-now btn btn-sm btn-primary">Give review</a>
						</security:authorize>
						<a href="/movies/byProvider/<c:out value="${user.id }"/>"
							class="buy-now btn btn-sm btn-primary">See posts</a>
					</c:if>
				</div>
			</div>

		</div>
		<c:if test="${user.userType eq 'Provider'}">
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
								<c:forEach items="${user.receivedReviews}" var="review">
									<div class="item">
										<div class="block-4">
											<div class="block-4-text p-2">
												<b>User: </b> <a
													href="/user/<c:out value="${review.customer.id }" />"><c:out
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
		</c:if>
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
