<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
						<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Sign up</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-3 text-black">Creating an account:</h2>
					</div>
					<div class="col-md-7">
						<form action="/register" method="POST">
							<div class="p-3 p-lg-5 border">
								<div class="form-group column">
									<div class="col-md-10" id="error">
										<c:if test="${not empty errorMessage }">
											<c:forEach items="${errorMessage }" var="message">
												<ul>
													<li
														style="color: red; font-weight: bold; margin: 30px 0px;"><c:out
															value="${message}"></c:out></li>
												</ul>
											</c:forEach>
										</c:if>
									</div>
									<div class="col-md-10">
										<label for="c_fname" class="text-black"><b> User
												Type </b><br> <input type="radio" name="userType"
											value="Customer" id="customerCheck"
											onclick="javascript:yesnoCheck();" checked="checked">
											Customer <input type="radio" name="userType" value="Provider"
											id="providerCheck" onclick="javascript:yesnoCheck();">
											Provider<br></label>
									</div>
									<div id="customerDiv">
										<div class="col-md-10">
											<label for="c_fname" class="text-black"><b>
													Username </b> <span class="text-danger">*</span></label> <input
												type="text" class="form-control" id="c_fname"
												name="userName">
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Password </b> <span class="text-danger">*</span></label> <input
												type="password" class="form-control" id="password"
												name="password" >
											<p>
												<small>*Must contain at least one number and one
													letter, and at least 8 or more characters!</small>
											</p>
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Confirm Password </b> <span class="text-danger">*</span></label> <input
												type="password" class="form-control" id="passwordConfirm"
												name="passwordConfirm" >
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b> Last
													Name </b> <span class="text-danger">*</span></label> <input type="text"
												class="form-control" id="c_lname" name="lastName" >
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b> First
													Name </b> <span class="text-danger">*</span></label> <input type="text"
												class="form-control" id="c_lname" name="firstName" >
										</div>
										<div class="col-md-10">
											<label for="c_email" class="text-black"><b> Email
											</b> <span class="text-danger">*</span></label> <input type="email"
												class="form-control" id="c_email" name="email"
												placeholder="" >
										</div>
										<div class="col-md-10">
											<label for="c_address" class="text-black"><b>Address</b><span
												class="text-danger">*</span></label> <br> <input type="text"
												class="form-control" id="ownState" name="state"
												placeholder="State" /> <input type="text"
												class="form-control" id="ownCity" name="city"
												placeholder="City"  />
										</div>
										<div class="col-md-10">
											<input type="text" class="form-control" id="c_address"
												name="address" placeholder="Street name, number etc."
												 />
										</div>
										<div class="col-md-10">
											<label for="c_sex" class="text-black"><b>Gender</b><span
												class="text-danger">*</span></label> <select name="sex"
												class="form-control">
												<option value="M">Male</option>
												<option value="F">Female</option>
											</select>
										</div>
										<div class="col-md-10">
											<label for="c_bDay" class="text-black"><b>Birth
													Date</b><span class="text-danger">*</span></label> <input type="date"
												class="form-control" id="c_bDay" name="birthDate"  />
										</div>
										<div class="col-md-10">
											<label for="c_phone" class="text-black"><b>Phone
													Number</b><span class="text-danger">*</span></label> <input type="text"
												class="form-control" id="c_phone" name="phoneNumber"
												 />
										</div>
										<br> <br> <input type="submit"
										class="btn btn-primary btn-lg btn-block" value="SIGN UP! ">
									</div>

									<div id="providerDiv" style="display: none">
										<div class="col-md-10">
											<label for="c_fname" class="text-black"><b>
													Company Name(This will be also the username) </b> <span
												class="text-danger">*</span></label> <input type="text"
												class="form-control" id="c_fname" name="userName" >
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Password </b> <span class="text-danger">*</span></label> <input
												type="password" class="form-control" id="password"
												name="password" >
											<p>
												<small>*Must contain at least one number and one
													letter, and at least 8 or more characters!</small>
											</p>
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Confirm Password </b> <span class="text-danger">*</span></label> <input
												type="password" class="form-control" id="passwordConfirm"
												name="passwordConfirm" >
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Billing Last Name </b> <span class="text-danger">*</span></label> <input
												type="text" class="form-control" id="c_lname"
												name="lastName" >
										</div>
										<div class="col-md-10">
											<label for="c_lname" class="text-black"><b>
													Billing First Name </b> <span class="text-danger">*</span></label> <input
												type="text" class="form-control" id="c_lname"
												name="firstName" >
										</div>
										<div class="col-md-10">
											<label for="c_email" class="text-black"><b>Company
													Email </b> <span class="text-danger">*</span></label> <input
												type="email" class="form-control" id="c_email" name="email"
												placeholder="" >
										</div>
										<div class="col-md-10">
											<label for="c_address" class="text-black"><b>Billing
													Address</b><span class="text-danger">*</span></label> <br> <input
												type="text" class="form-control" id="ownState" name="state"
												placeholder="State" /> <input type="text"
												class="form-control" id="ownCity" name="city"
												placeholder="City"  />
										</div>
										<div class="col-md-10">
											<input type="text" class="form-control" id="c_address"
												name="address" placeholder="Street name, number etc."
												 />
										</div>
										<div class="col-md-10">
											<label for="c_phone" class="text-black"><b>Phone
													Number</b><span class="text-danger">*</span></label> <input type="text"
												class="form-control" id="c_phone" name="phoneNumber"
												 />
										</div>
										<div class="col-md-10">
											<label for="c_paymentPlan" class="text-black"><b>Payment
													Plan</b><span class="text-danger">*</span></label> <select
												name="paymentPlan" class="form-control" id="plan" onchange="displayStuff()">
												<option value="Basic">Basic, $4.99/month</option>
												<option value="Advanced">Advanced, $10.99/month</option>
												<option value="Ultimate">Ultimate, 15.99/month</option>
											</select>
											<p id="Basic">
												<small><i class="icon-info-circle"></i> Basic: you will be able
													to have only 20 posts(movies) for sale/rent, and a stock of
													40/movie.</small>
											</p>
											<p id="Advanced" style="display:none">
												<small><i class="icon-info-circle"></i> Advanced: you will be able
													to have only 50 posts(movies) for sale/rent, and a stock of
													100/movie.</small>
											</p>
											<p id="Ultimate" style="display:none">
												<small><i class="icon-info-circle"></i> Ultimate: you will be able
													to have unlimited posts and unlimited stock.</small>
											</p>
											<br> <br> <input type="submit"
										class="btn btn-primary btn-lg btn-block" value="SIGN UP! ">
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-5 ml-auto">
						<br> <br>

						<div class"col-lg-12" align="center">
							<a href="/login" class="btn btn-primary btn-lg btn-block"><b>Already
									have an account? </b></a>
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

	<script type="text/javascript">
		function yesnoCheck() {
			if (document.getElementById('customerCheck').checked) {
				document.getElementById('customerDiv').style.display = 'block';
				document.getElementById('providerDiv').style.display = 'none';
				document.getElementById('providerDiv').getElementsByTagName('input').required = false;
				document.getElementById('providerDiv').getElementsByTagName('select').required = false;
				document.getElementById('customerDiv').getElementsByTagName('input').required = true;
			} else if (document.getElementById('providerCheck').checked) {
				document.getElementById('providerDiv').style.display = 'block';
				document.getElementById('customerDiv').style.display = 'none';
				document.getElementById('providerDiv').getElementsByTagName('input').required = true;
				document.getElementById('providerDiv').getElementsByTagName('select').required = true;
				document.getElementById('customerDiv').getElementsByTagName('input').required = false;
			}
		}
	</script>
	<script type="text/javascript">
		function displayStuff() {
			var e = document.getElementById('plan');
			var val = e.options[e.selectedIndex].value;

			switch (val) {
			case "Basic":
				document.getElementById('Basic').style.display = 'block';
				document.getElementById('Advanced').style.display = 'none';
				document.getElementById('Ultimate').style.display = 'none';
				break;
			case "Advanced":
				document.getElementById('Advanced').style.display = 'block';
				document.getElementById('Basic').style.display = 'none';
				document.getElementById('Ultimate').style.display = 'none';
				break;
			case "Ultimate":
				document.getElementById('Ultimate').style.display = 'block';
				document.getElementById('Basic').style.display = 'none';
				document.getElementById('Advanced').style.display = 'none';
				break;
			}

		}
	</script>
</body>
</html>
