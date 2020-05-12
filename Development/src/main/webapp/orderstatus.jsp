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

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
<link rel="stylesheet" href="/fonts/icomoon/style.css">
<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
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
					<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Order Status</strong>
				</div>
			</div>
		</div>
	</div>


	<div class="container px-1 px-md-4 py-5 mx-auto">
		<div class="card">
			<div class="row d-flex justify-content-between px-3 top">
				<div class="d-flex">
					<h5>
						ORDER <span class="text-primary font-weight-bold">#<c:out
								value="${order.id}" /></span>
					</h5>
				</div>
				<div class="d-flex flex-column text-sm-right">
					<p class="mb-0">
						Expected Arrival <span><c:out value="${order.shippingDate}" /></span>
					</p>
				</div>
			</div>
			<div class="row d-flex justify-content-center">
				<div class="col-12">
					<ul id="progressbar" class="text-center">
						<c:choose>
							<c:when test="${order.status == 'Placed' }">
								<li class="active step0"></li>
								<li class="step0"></li>
								<li class="step0"></li>
							</c:when>
							<c:when test="${order.status == 'Sent' }">
								<li class="active step0"></li>
								<li class="active step0"></li>
								<li class="step0"></li>
							</c:when>
							<c:when test="${order.status == 'Delivered' }">
								<li class="active step0"></li>
								<li class="active step0"></li>
								<li class="active step0"></li>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</div>
			<div class="row justify-content-between top">
				<div class="row d-flex icon-content">
					<img class="icon" src="https://i.imgur.com/9nnc9Et.png">
					<div class="d-flex flex-column">
						<p class="font-weight-bold">
							Order<br>Processed
						</p>
					</div>
				</div>
				<div class="row d-flex icon-content">
					<img class="icon" src="https://i.imgur.com/u1AzR7w.png">
					<div class="d-flex flex-column">
						<p class="font-weight-bold">
							Order<br>Shipped
						</p>
					</div>
				</div>
				<div class="row d-flex icon-content">
					<img class="icon" src="https://i.imgur.com/HdsziHP.png">
					<div class="d-flex flex-column">
						<p class="font-weight-bold">
							Order<br>Arrived
						</p>
					</div>
				</div>
			</div>

			<p align="center">
				<a href="/order/<c:out value="${order.id}"/>"
					class="buy-now btn btn-sm btn-primary">See order details</a>
			</p>

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
