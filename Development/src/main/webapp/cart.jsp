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
								<li><a href="/provider/1"><span
										class="icon icon-person"></span></a></li>
								<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
								<li><a href="cart.jsp" class="site-cart"> <span
										class="icon icon-shopping_cart"></span> <span class="count">2</span>
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
						<a href="index.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Cart</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-5">
					<form class="col-md-12" method="post">
						<div class="site-blocks-table">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="product-thumbnail">Cover</th>
										<th class="product-name">Movie Name</th>
										<th class="product-price">Price</th>
									</tr>
								</thead>
								<c:forEach items="${movies}" var="movie">
									<tbody>
										<tr>
											<td class="product-thumbnail"><img
												style="width: 400px; height: 200px;" src="images/movie.jpg"
												alt="Image" class="img-fluid"></td>
											<td class="product-name">
												<h2 class="h5 text-black">${movie.name}</h2>
											</td>
											<td>${movie.buyPrice}</td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>
					</form>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="row mb-5">
							<div class="col-md-6 mb-3 mb-md-0">
								<button class="btn btn-primary btn-sm btn-block">Update
									Cart</button>
							</div>
							<div class="col-md-6">
								<button class="btn btn-outline-primary btn-sm btn-block">Continue
									Shopping</button>
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
										<button class="btn btn-primary btn-lg py-3 btn-block"
											onclick="window.location='checkout.jsp'">Proceed To
											Checkout</button>
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
