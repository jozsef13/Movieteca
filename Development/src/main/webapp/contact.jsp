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
						<a href="/">Home</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">Contact</strong>
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
					<div class="col-md-12">
						<h2 class="h3 mb-3 text-black">Send Message/Request</h2>
					</div>
					<c:if test="${empty request }">
						<div class="col-md-7">
							<form action="/contact/sendRequest" method="post">
								<div class="p-3 p-lg-5 border">
									<div class="form-group row">
										<div class="col-md-12">
											<label for="c_subject" class="text-black">Subject <span
												class="text-danger">*</span></label> <input type="text"
												class="form-control" id="requestType" name="requestType"
												required> <small><i class="icon-info-circle"></i>
												The subject must be short and describe the request/problem.
												Example: "Add movie", "Edit movie", "Report user" etc.</small>
										</div>
									</div>

									<div class="form-group row">
										<div class="col-md-12">
											<label for="c_message" class="text-black">Message <span
												class="text-danger">*</span></label>
											<textarea name="requestObject" id="requestObject" cols="30"
												rows="7" class="form-control" required></textarea>
											<small><i class="icon-info-circle"></i> Give all the
												details about the problem! If you request for adding a
												movie, you have to write the details about the movie, as
												well as stock and prices(buy and rent)!</small>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-12">
											<input type="submit" class="btn btn-primary btn-lg btn-block"
												value="Send Message">
										</div>
									</div>
								</div>
							</form>
						</div>
					</c:if>

					<c:if test="${not empty request }">
						<div class="col-md-7">
							<form action="" method="post">
								<div class="p-3 p-lg-5 border">
									<div class="form-group row">
										<div class="col-md-12">
											<c:if test="${not empty request.provider }">
												<label for="provider" class="text-black">Request
													from <a
													href="/user/<c:out value="${request.provider.id }"/>"><c:out
															value="${request.provider.userName }" /></a>
												</label>
											</c:if>
											<c:if test="${not empty request.customer }">
												<label for="provider" class="text-black">Request
													from <a
													href="/user/<c:out value="${request.customer.id }"/>"><c:out
															value="${request.customer.userName }" /></a>
												</label>
											</c:if>
										</div>
									</div>
									<div class="form-group row">
										<div class="col-md-12">
											<label for="c_subject" class="text-black">Subject <span
												class="text-danger"></span></label> <input type="text"
												class="form-control" id="requestType" name="requestType"
												readonly value="${request.requestType }">
										</div>
									</div>
									<security:authorize access="hasRole('Admin')">
										<div class="form-group row">
											<div class="col-md-12">
												<label for="c_message" class="text-black">Message <span
													class="text-danger"></span></label>
												<textarea name="requestObject" id="requestObject" cols="30"
													rows="7" class="form-control"><c:out
														value="${request.requestObject }" /></textarea>
											</div>
										</div>
									</security:authorize>
									<security:authorize access="hasAnyRole('Provider', 'Customer')">
										<div class="form-group row">
											<div class="col-md-12">
												<label for="c_message" class="text-black">Message <span
													class="text-danger">*</span></label>
												<textarea name="requestObject" id="requestObject" cols="30"
													rows="7" class="form-control" readonly><c:out
														value="${request.requestObject }" /></textarea>
											</div>
										</div>
									</security:authorize>
									<div class="form-group row">
										<div class="col-lg-12">
											<security:authorize access="hasRole('Admin')">
												<c:if test="${not empty request.provider }">
													<a
														href="/contact/request/approve/<c:out value="${request.id }"/>"
														class="btn btn-primary btn-lg btn-block">Approve</a>

													<a
														href="/contact/request/deny/<c:out value="${request.id }"/>"
														class="btn btn-danger btn-lg btn-block">Deny</a>
												</c:if>
												<c:if test="${not empty request.customer }">
													<a
														href="/contact/request/approve/<c:out value="${request.id }"/>"
														class="btn btn-primary btn-lg btn-block">Send</a>
												</c:if>
											</security:authorize>
											<security:authorize access="hasAnyRole('Provider')">
												<p>
													<c:out value="${request.status }"></c:out>
												</p>
											</security:authorize>
										</div>
									</div>
								</div>
							</form>
						</div>
					</c:if>

					<div class="col-md-5 ml-auto">
						<div class="p-4 border mb-3">
							<span class="d-block text-primary h6 text-uppercase">Romania
							</span>
							<p class="mb-0">Calea Bucuresti, nr. 78, Craiova, Dolj</p>
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
</body>
</html>
