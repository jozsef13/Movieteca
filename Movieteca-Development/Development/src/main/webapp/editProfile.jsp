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
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />

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
						<a href="/myaccount">My Account</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Edit Profile</strong>
					</div>
				</div>
			</div>
		</div>
		<security:authorize access="isAuthenticated()">
			<div class="site-section">
				<div class="container">
					<div class="row">
						<security:authentication property="principal.user.userType"
							var="role" />
						<form action="/user/edit/<c:out value="${role }"/>" method="post" enctype="multipart/form-data">
								
							<div class="col-md-12">
								<u><h2 class="text-black">Account Info</h2></u>
								Profile picture: <input type="file" class="form-control"
									id="img" name="img">
									<br> 
									<b>Username:</b>
								<input type="text" class="form-control" name="userName"
									id="c_username" value="<security:authentication property="principal.username" />" readonly />
								<br><b>Password: </b><input type="password" class="form-control" name="password" id="c_password" value="<security:authentication property="principal.password"/>"/>
								<br> <b>Last Name:</b> <input type="text"
									class="form-control" name="lastName" id="c_lastName" value="<security:authentication property="principal.user.lastName" />"/>
								
								<br> <b>First Name:</b> <input type="text"
									class="form-control" name="firstName" id="c_firstName" value="<security:authentication property="principal.user.firstName" />" />
								
								<br> <b>Email:</b> <input type="text" class="form-control"
									name="email" id="c_email" readonly value="<security:authentication property="principal.user.email" />"/>
								
								<br> <b>Birthdate:</b> <input type="date"
									class="form-control" name="birthDate" id="c_bDay" value="<security:authentication property="principal.user.birthDate" />">
								
								<br> <b>Location:</b>
								<div class="col-md-12">
									<input type="text" class="form-control" name="city"
										id="c_city" value="<security:authentication property="principal.user.city" />"/>
									
								</div>
								<div class="col-md-12">
									<input type="text" class="form-control" name="state"
										id="c_state" value="<security:authentication property="principal.user.state" />"/>
									
								</div>
								<div class="col-md-12">
									<input type="text" class="form-control" name="country" id="c_country" value="<security:authentication property="principal.user.country" />" readonly/>
									
								</div>
								<br> <b>Address:</b> <input type="text"
									class="form-control" name="address" id="c_address"  value="<security:authentication property="principal.user.address" />"/>
								
								<br> <b>Phone Number:</b> <input type="text"
									class="form-control" name="phoneNumber" id="c_phoneNumber" value="<security:authentication property="principal.user.phoneNumber" />"/>
								
								<br> <b>Gender:</b> <input type="text" class="form-control"
									name="sex" id="c_sex" readonly value="<security:authentication property="principal.user.sex" />"/>
								
								<br> <input type="submit" value="Submit"
								class="buy-now btn btn-sm btn-primary">
							</div>
							
						</form>
					</div>
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
