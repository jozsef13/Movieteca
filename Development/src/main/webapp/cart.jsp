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

<style>
.divTable {
	display: table;
	width: 100%;
}

.divTableRow {
	display: table-row;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
}

.divTableCell, .divTableHead {
	border: 1px solid #999999;
	display: table-cell;
	padding: 3px 10px;
}

.divTableHeading {
	background-color: #EEE;
	display: table-header-group;
	font-weight: bold;
}

.divTableFoot {
	background-color: #EEE;
	display: table-footer-group;
	font-weight: bold;
}

.divTableBody {
	display: table-row-group;
}
</style>

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
							class="text-black">Cart</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-5">
					<div class="col-md-12">
						<div class="site-blocks-table">
							<div class="divTable">
								<div class="divTableHeading">
									<div class="divTableRow">
										<div class="divTableHead">Cover</div>
										<div class="divTableHead">Movie Name</div>
										<div class="divTableHead">Rent/Buy</div>
										<div class="divTableHead">Price</div>
										<div class="divTableHead">Quantity</div>
										<div class="divTableHead">Total Price</div>
										<div class="divTableHead">Remove</div>
									</div>
								</div>
								<c:forEach items="${cart.moviesInCart}" var="movie">
									<div class="divTableBody">
										<div class="divTableRow">
											<div class="divTableCell">
												<img style="width: 200px; height: 200px;"
													src="<c:out value="${movie.imagePath}" />" alt="Image"
													class="img-fluid">
											</div>
											<div class="divTableCell">
												<h2 class="h5 text-black">${movie.name}</h2>
											</div>
											<div class="divTableCell">
												<form action="/cart/updateType/<c:out value="${movie.id}"/>">
													<div class="mb-6">
														<select id="orderType" name="orderType">
															<option value="${movie.orderType}">${movie.orderType}</option>
															<c:choose>
																<c:when test="${movie.orderType == 'Buy'}">
																	<option value="Rent">Rent</option>
																</c:when>
																<c:otherwise>
																	<option value="Buy">Buy</option>
																</c:otherwise>
															</c:choose>
														</select> <br> <br> <input type="submit" value="Change"
															class="btn btn-primary btn-sm">
													</div>
												</form>
											</div>
											<div class="divTableCell">
												<c:choose>
													<c:when test="${movie.orderType == 'Buy' }">
														$<c:out value="${movie.buyPrice}" />
													</c:when>
													<c:otherwise>
														$<c:out value="${movie.rentPrice}" />
													</c:otherwise>
												</c:choose>
											</div>
											<div class="divTableCell">
												<form
													action="/cart/updateMovieQuantity/<c:out value="${movie.id}"/>">
													<div class="mb-6">
														<div class="input-group mb-3" style="max-width: 120px;">
															<div class="input-group-prepend">
																<button class="btn btn-outline-primary js-btn-minus"
																	type="button">&minus;</button>
															</div>
															<input type="text" class="form-control text-center"
																value="<c:out value="${movie.orderQuantity}"/>"
																name="orderQuantity" id="orderQuantity">
															<div class="input-group-append">
																<button class="btn btn-outline-primary js-btn-plus"
																	type="button">&plus;</button>
															</div>
														</div>
														<input type="submit" class="btn btn-primary btn-sm"
															value="Update">
													</div>
												</form>
											</div>
											<div class="divTableCell">
												<c:choose>
													<c:when test="${movie.orderType == 'Buy' }">
														$<c:out value="${movie.orderQuantity * movie.buyPrice}" />
													</c:when>
													<c:otherwise>
														$<c:out value="${movie.orderQuantity * movie.rentPrice}" />
													</c:otherwise>
												</c:choose>
											</div>
											<div class="divTableCell">
												<a href="/cart/deleteMovie/<c:out value="${movie.id}"/>"
													class="btn btn-primary btn-sm">X</a>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-6">
						<div class="row mb-5">
							<div class="col-md-6">
								<a href="/movies"><button
										class="btn btn-outline-primary btn-sm btn-block">Continue
										Shopping</button></a>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label class="text-black h4" for="coupon">Coupon</label>
								<p>Enter your coupon code if you have one.</p>
							</div>
							<div class="col-md-8 mb-3 mb-md-0">
								<input type="text" class="form-control py-3" id="coupon"
									placeholder="Coupon Code">
							</div>
							<div class="col-md-4">
								<button class="btn btn-primary btn-sm">Apply Coupon</button>
							</div>
						</div>
					</div>
					<br>
					<div class="col-md-6 pl-5">
						<div class="row justify-content-end">
							<div class="col-md-7">
								<div class="row">
									<div class="col-md-12 text-right border-bottom mb-5">
										<h3 class="text-black h4 text-uppercase">Cart Totals</h3>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col-md-6">
										<span class="text-black">Subtotal</span>
									</div>
									<div class="col-md-6 text-right">
										<strong class="text-black">${cart.totalPrice}</strong>
									</div>
								</div>
								<div class="row mb-5">
									<div class="col-md-6">
										<span class="text-black">Total</span>
									</div>
									<div class="col-md-6 text-right">
										<strong class="text-black">${cart.totalPrice}</strong>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<a href="/cart/placeOrder/<c:out value="${cart.id}"/>"><button
												class="btn btn-primary btn-lg py-3 btn-block">Place
												Order</button></a>
									</div>
								</div>
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
