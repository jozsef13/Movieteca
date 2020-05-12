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
						<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <a
							href="/cart.jsp">Cart</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Checkout</strong>
					</div>
				</div>
			</div>
		</div>

		<security:authorize access="hasRole('Customer')">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<div class="col-md-6 mb-5 mb-md-0">
							<h2 class="h3 mb-3 text-black">Billing Details</h2>
							<div class="p-3 p-lg-5 border">
								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_fname" class="text-black">First Name <span
											class="text-danger"></span></label> <br>
										<security:authentication property="principal.user.firstName" />
									</div>
									<div class="col-md-6">
										<label for="c_lname" class="text-black">Last Name <span
											class="text-danger"></span></label> <br>
										<security:authentication property="principal.user.lastName" />
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-12">
										<label for="c_address" class="text-black">Address <span
											class="text-danger"></span></label> <br>
										<security:authentication property="principal.user.address" />
									</div>
								</div>

								<div class="form-group row">
									<div class="col-md-6">
										<label for="c_state_country" class="text-black">State
											/ County <span class="text-danger"></span>
										</label><br>
										<security:authentication property="principal.user.state" />
									</div>
									<div class="col-md-6">
										<label for="c_postal_zip" class="text-black">City <span
											class="text-danger"></span>
										</label><br>
										<security:authentication property="principal.user.city" />
									</div>
								</div>

								<div class="form-group row mb-5">
									<div class="col-md-6">
										<label for="c_email_address" class="text-black">Email
											Address <span class="text-danger"></span>
										</label><br>
										<security:authentication property="principal.user.email" />
									</div>
									<div class="col-md-6">
										<label for="c_phone" class="text-black">Phone <span
											class="text-danger"></span></label><br>
										<security:authentication property="principal.user.phoneNumber" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="row mb-5">
								<div class="col-md-12">
									<h2 class="h3 mb-3 text-black">Your Order</h2>
									<div class="p-3 p-lg-5 border">
										<table class="table site-block-order-table mb-5">
											<thead>
												<th>Product</th>
												<th>Total</th>
											</thead>
											<tbody>
												<c:forEach items="${cart.moviesInCart}" var="movie">
													<tr>
														<td><c:out value="${movie.name }"></c:out> <strong
															class="mx-2">x</strong> <c:out
																value="${movie.orderQuantity }"></c:out><br> <c:out
																value="${movie.orderType }"></c:out></td>
														<td><c:choose>
																<c:when test="${movie.orderType eq 'Buy'}">
																	<c:out value="${movie.buyPrice * movie.orderQuantity }"></c:out>
																</c:when>
																<c:when test="${movie.orderType eq 'Rent' }">
																	<c:out
																		value="${movie.rentPrice * movie.orderQuantity }"></c:out>
																</c:when>
															</c:choose></td>
													</tr>
												</c:forEach>
												<tr>
													<td class="text-black font-weight-bold"><strong>Order
															Total</strong></td>
													<td class="text-black font-weight-bold"><strong><c:out
																value="${cart.totalPrice}"></c:out></strong></td>
												</tr>
											</tbody>

										</table>
										<div class="form-group">
											<div class="col-md-6" style="display: inline">
												<a href="/cart/placeOrder/<c:out value="${cart.id}"/>"><button
														class="btn btn-primary btn-lg py-3 btn-block">Place
														Order</button></a>
											</div>
											<div class="col-md-6" style="display: inline">
												<a href="/cart/<c:out value="${cart.id}"/>"><button
														class="btn btn-primary btn-lg py-3 btn-block">Back
														to cart</button></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- </form> -->
				</div>
			</div>
		</security:authorize>
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
