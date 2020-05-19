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
						<a href="/">Movies</a> <span class="mx-2 mb-0">/</span> <strong
							class="text-black">My Account</strong>
					</div>
				</div>
			</div>
		</div>
		<security:authorize access="isAuthenticated()">
			<div class="site-section">
				<div class="container">
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
					<div class="row">
						<security:authentication property="principal.user.profilePicture"
							var="picture" />
						<div class="col-md-6">
							<c:choose>
								<c:when test="${ not empty picture}">
									<img style="width: 450px; height: 400px;" src="${picture}"
										alt="Image placeholder" class="img-fluid">
								</c:when>
								<c:otherwise>
									<security:authentication property="principal.user.sex"
										var="gender" />
									<c:if test="${gender eq 'M'}">
										<img style="width: 450px; height: 400px;"
											src="/images/avatarm.png" alt="Image placeholder"
											class="img-fluid">
									</c:if>
									<c:if test="${gender eq 'F' }">
										<img style="width: 450px; height: 400px;"
											src="/images/avatarf.jpg" alt="Image placeholder"
											class="img-fluid">
									</c:if>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-md-6">
							<u><h2 class="text-black">Account Info</h2></u>

							<p>
								Username:
								<security:authentication property="principal.username" />
							</p>
							<p>
								Last Name:
								<security:authentication property="principal.user.lastName" />
							</p>
							<p>
								First Name:
								<security:authentication property="principal.user.firstName" />
							</p>
							<p>
								E-Mail:
								<security:authentication property="principal.user.email" />
							</p>
							<p>
								Birthdate:
								<security:authentication property="principal.user.birthDate" />
							</p>
							<p>
								Location:
								<security:authentication property="principal.user.city" />
								,
								<security:authentication property="principal.user.state" />
								,
								<security:authentication property="principal.user.country" />
							</p>
							<p>
								Address:
								<security:authentication property="principal.user.address" />
							</p>
							<p>
								Phone Number:
								<security:authentication property="principal.user.phoneNumber" />
							</p>
							<p>
								Gender:
								<security:authentication property="principal.user.sex" />
							</p>
							<security:authorize access="hasAnyRole('Provider')">
								<p>
									Payment Plan:
									<security:authentication
										property="principal.user.paymentPlan.planType" />
								</p>
							</security:authorize>
						</div>
					</div>
					<br>
					<p>
						<a href="/editProfile" class="buy-now btn btn-sm btn-primary">Edit
							profile</a>
						<security:authorize access="hasAnyRole('Admin')">
							<a href="/movies/edit" class="buy-now btn btn-sm btn-primary">Edit
								movie list</a>
						</security:authorize>
						<security:authorize access="hasAnyRole('Provider')">
							<a
								href="/movies/provider/<security:authentication property="principal.user.id"/>"
								class="buy-now btn btn-sm btn-primary">Edit posts</a>
						</security:authorize>

						<a
							href="/user/delete/<security:authentication property="principal.user.id"/>"
							class="buy-now btn btn-sm btn-danger">Delete account</a>
					</p>
				</div>
				<security:authorize access="hasAnyRole('Customer')">
					<security:authentication property="principal.user.orders"
						var="orders" />
						<security:authentication property="principal.user.requestsSent"
						var="requests" />
					<security:authentication property="principal.user.messages"
						var="messages" />
					<security:authentication
						property="principal.user.providerReviewsAdded"
						var="providerReviews" />
					<security:authentication
						property="principal.user.movieReviewsAdded" var="movieReviews" />
					<div class="container">
						<div class="row">
							<div class="col-md-3">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseOne-alt3"> <i class="fa fa-angle-right"></i>
													Orders(<c:out value="${orders.size()}"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseOne-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${orders}" var="order">
														<li><a
															href="/order/status/<c:out value="${order.id }"/>">Order
																#<c:out value="${order.id}" />, <c:out
																	value="${order.status}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseTwo-alt3"> <i class="fa fa-angle-right"></i>
													Reviews(<c:out
														value="${providerReviews.size() + movieReviews.size()}"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseTwo-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${providerReviews}" var="providerReview">
														<li><a
															href="/user/<c:out value="${providerReview.provider.id }"/>">Review
																#<c:out value="${providerReview.id}" /> for <c:out
																	value="${providerReview.provider.userName}" />
														</a></li>
													</c:forEach>
													<c:forEach items="${movieReviews}" var="movieReview">
														<li><a
															href="/movie/<c:out value="${movieReview.movie.id }"/>">Review
																#<c:out value="${movieReview.id}" /> for <c:out
																	value="${movieReview.movie.name}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseThree-alt3"> <i
													class="fa fa-angle-right"></i> Messages(<c:out
														value="${messages.size() }"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseThree-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${messages}" var="message">
														<li><a
															href="/sendMessage/<c:out value="${message.provider.id }"/>">Message
																#<c:out value="${message.id}" />, <c:out
																	value="${message.provider.userName}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-md-3">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseFour-alt3"> <i
													class="fa fa-angle-right"></i> Requests(<c:out
														value="${requests.size() }"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseFour-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${requests}" var="request">
														<li><a
															href="/request/<c:out value="${request.id }"/>">Request
																#<c:out value="${request.id}" />, <c:out
																	value="${request.status}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</security:authorize>


				<security:authorize access="hasAnyRole('Provider')">
					<security:authentication property="principal.user.requestsSent"
						var="requests" />
					<security:authentication property="principal.user.messages"
						var="messages" />
					<security:authentication property="principal.user.receivedReviews"
						var="reviews" />
					<div class="container">
						<div class="row">
							<div class="col-md-4">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseOne-alt3"> <i class="fa fa-angle-right"></i>
													Requests(<c:out value="${requests.size()}"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseOne-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${requests}" var="request">
														<li><a
															href="/request/<c:out value="${request.id }"/>">Request
																#<c:out value="${request.id}" />, <c:out
																	value="${request.status}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseTwo-alt3"> <i class="fa fa-angle-right"></i>
													Reviews(<c:out value="${reviews.size()}"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseTwo-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${reviews}" var="review">
														<li><a
															href="/user/<c:out value="${review.provider.id }"/>">Review
																#<c:out value="${review.id}" /> for <c:out
																	value="${review.customer.userName}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseThree-alt3"> <i
													class="fa fa-angle-right"></i> Messages(<c:out
														value="${messages.size() }"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseThree-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${messages}" var="message">
														<li><a
															href="/sendMessage/<c:out value="${message.customer.id }"/>">Conversation
																#<c:out value="${message.id}" />, <c:out
																	value="${message.customer.userName}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</security:authorize>



				<security:authorize access="hasAnyRole('Admin')">
					<security:authentication property="principal.user.receivedRequests"
						var="requests" />
					<div class="container">
						<div class="row">
							<div class="col-md-4">
								<div class="panel-group" id="accordion-alt3">
									<!-- Panel. Use "panel-XXX" class for different colors. Replace "XXX" with color. -->
									<div class="panel">
										<!-- Panel heading -->
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion-alt3"
													href="#collapseOne-alt3"> <i class="fa fa-angle-right"></i>
													Requests Received(<c:out value="${requests.size()}"></c:out>)
												</a>
											</h4>
										</div>
										<div id="collapseOne-alt3" class="panel-collapse collapse">
											<div class="panel-body">
												<ul>
													<c:forEach items="${requests}" var="request">
														<li><a
															href="/request/<c:out value="${request.id }"/>">Order
																#<c:out value="${request.id}" />, <c:out
																	value="${request.status}" />
														</a></li>
													</c:forEach>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</security:authorize>
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
	<script>
		var fade_out = function() {
			$("#error").fadeOut().empty();
		}

		setTimeout(fade_out, 5000);
	</script>
</body>
</html>
