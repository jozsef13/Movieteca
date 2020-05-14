<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

/* Firefox */
input[type=number] {
	-moz-appearance: textfield;
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
							class="text-black">Movies</strong>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">

				<div class="row mb-5">
					<div class="col-md-9 order-2">

						<div class="row">
							<div class="col-md-12 mb-5">
								<div class="float-md-left mb-4">
									<h2 class="text-black h5">All our collection</h2>
								</div>
								<div class="d-flex">
									<div class="dropdown mr-1 ml-md-auto">
										<button type="button"
											class="btn btn-secondary btn-sm dropdown-toggle"
											id="dropdownMenuOffset" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">Latest</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuOffset">
											<a class="dropdown-item" href="/movies">Movies</a>
										</div>
									</div>
									<div class="btn-group">
										<button type="button"
											class="btn btn-secondary btn-sm dropdown-toggle"
											id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuReference">
											<c:set var="orderTypeA" scope="session" value="aToZ" />
											<c:set var="orderTypeZ" scope="session" value="zToA" />
											<c:set var="orderTypeBA" scope="session"
												value="BuyPriceAscending" />
											<c:set var="orderTypeBD" scope="session"
												value="BuyPriceDescending" />
											<c:set var="orderTypeRA" scope="session"
												value="RentPriceAscending" />
											<c:set var="orderTypeRB" scope="session"
												value="RentPriceDescending" />
											<a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeA}"/>">Name,
												A to Z</a> <a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeZ}"/>">Name,
												Z to A</a> <a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeBA}"/>">Buy
												Price, Ascending</a> <a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeBD}"/>">Buy
												Price, Descending</a> <a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeRA}"/>">Rent
												Price, Ascending</a> <a class="dropdown-item"
												href="/movies?sortType=<c:out value = "${orderTypeRB}"/>">Rent
												Price, Descending</a>
											<div class="dropdown-divider"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">
							<c:forEach items="${movies}" var="movie">
								<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
									<div class="block-4 text-center border">
										<figure class="block-4-image"> <a
											href="/movie/<c:out value="${movie.id}" />"><img
											style="width: 500px; height: 300px;"
											src="<c:out value="${movie.imagePath}" />"
											alt="Image placeholder" class="img-fluid"></a> </figure>
										<div class="block-4-text p-4">
											<h3>
												<a href="/movie/<c:out value="${movie.id}"/>"><c:out
														value="${movie.name}" /></a>
											</h3>
											<p class="mb-0 rated">
												<span>Rating: <span class="fa fa-star checked"></span>
													<span class="fa fa-star checked"></span> <span
													class="fa fa-star checked"></span> <span class="fa fa-star"></span>
													<span class="fa fa-star"></span></span>
											</p>
											<p>
												<strong class="text-primary h4"><c:out
														value="${movie.rentPrice}" />$ / <c:out
														value="${movie.buyPrice}" />$</strong>
											</p>
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
											<p>
											<security:authorize access="hasAnyRole('Customer')">
												<c:choose>
													<c:when test="${movie.stock > 0 }">
														<form
															action="/addToCart/Movie/<c:out value="${movie.id}" />">
															<input type="radio" name="orderType" value="Rent">
															<label for="male">Rent</label> <input type="radio"
																name="orderType" value="Buy"> <label
																for="female">Buy</label> <br> <input type="submit"
																name="Add to Cart" value="Add to Cart">
														</form>
													</c:when>
													<c:when test="${movie.stock <= 0 }">
														<form
															action="/addToCart/Movie/<c:out value="${movie.id}" />">
															<input type="radio" name="orderType" value="Rent"
																disabled> <label for="male">Rent</label> <input
																type="radio" name="orderType" value="Buy" disabled>
															<label for="female">Buy</label> <br> <input
																type="submit" name="Add to Cart" value="Add to Cart"
																disabled>
														</form>
													</c:when>
												</c:choose>
												</security:authorize>
											</p>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<c:if test="${empty sortTypeName }">
											<c:if test="${currentPage != 1 }">
												<li><a href="/movies?page=${currentPage-1}">&lt;</a></li>
											</c:if>

											<c:forEach begin="1" end="${noOfPages}" var="i">
												<c:choose>
													<c:when test="${currentPage eq i }">
														<li class="active"><span>${i}</span></li>
													</c:when>
													<c:otherwise>
														<li><a href="/movies?page=${i}">${i}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:if test="${currentPage lt noOfPages }">
												<li><a href="/movies?page=${currentPage+1}">&gt;</a></li>
											</c:if>
										</c:if>
										<c:if test="${not empty sortTypeName }">
											<c:if test="${currentPage != 1 }">
												<li><a
													href="/movies?page=${currentPage-1}&sortType=<c:out value = "${sortTypeName}"/>">&lt;</a></li>
											</c:if>

											<c:forEach begin="1" end="${noOfPages}" var="i">
												<c:choose>
													<c:when test="${currentPage eq i }">
														<li class="active"><span>${i}</span></li>
													</c:when>
													<c:otherwise>
														<li><a
															href="/movies?page=${i}&sortType=<c:out value = "${sortTypeName}"/>">${i}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:if test="${currentPage lt noOfPages }">
												<li><a
													href="/movies?page=${currentPage+1}&sortType=<c:out value = "${sortTypeName}"/>">&gt;</a></li>
											</c:if>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-3 order-1 mb-5 mb-md-0">
						<div class="border p-4 rounded mb-4">
							<h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
							<ul class="list-unstyled mb-0">
								<li class="mb-1"><a href="/movies" class="d-flex"><span>Movies</span>
										<span class="text-black ml-auto">(<c:out
												value="${numberOfMovies}" />)
									</span></a></li>
							</ul>
						</div>

						<div class="border p-4 rounded mb-4">
							<div class="mb-4">
								<form action="/movies/byPrice">
									<h3 class="mb-3 h6 text-uppercase text-black d-block">Filter
										by</h3>
									<select id="priceType" name="priceType">
										<option value="buyPrice">Buy price</option>
										<option value="rentPrice">Rent price</option>
									</select> <br>
									<div class="ui-grid-a">
										<div data-role="fieldcontain" class="ui-hide-label ui-block a">
											<input type="number" min="0" name="minPrice" id="minPrice"
												placeholder="min">
										</div>
										<div data-role="fieldcontain" class="ui-hide-label ui-block b">
											<input type="number" min="0" name="maxPrice" id="maxPrice"
												placeholder="max">
										</div>
									</div>
									<br> <input type="submit"
										class="buy-now btn btn-sm btn-primary" value="Filter">
								</form>
							</div>

							<div class="mb-4">
								<form action="/movies/genre">
									<h3 class="mb-3 h6 text-uppercase text-black d-block">Genre</h3>
									<div class="col-md-10" id="error">
										<c:if test="${not empty errorMessage }">
											<p style="color: red; font-weight: bold; margin: 30px 0px;">
												<i class="icon-info-circle"></i> <c:out value="${errorMessage}"></c:out>
											</p>
										</c:if>
									</div>
									<label for="s_sm" class="d-flex"> <input
										type="checkbox" name="genre" value="Action" class="mr-2 mt-1">
										<span class="text-black">Action</span>
									</label> <label for="s_md" class="d-flex"> <input
										type="checkbox" name="genre" value="Adventure"
										class="mr-2 mt-1"> <span class="text-black">Adventure</span>
									</label><label for="s_sm" class="d-flex"> <input
										type="checkbox" name="genre" value="Animation"
										class="mr-2 mt-1"> <span class="text-black">Animation</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Comedy" class="mr-2 mt-1">
										<span class="text-black">Comedy</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Crime" class="mr-2 mt-1">
										<span class="text-black">Crime</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Drama" class="mr-2 mt-1">
										<span class="text-black">Drama</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Fantasy" class="mr-2 mt-1">
										<span class="text-black">Fantasy</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Historical"
										class="mr-2 mt-1"> <span class="text-black">Historical</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Horro" class="mr-2 mt-1">
										<span class="text-black">Horror</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Mystery" class="mr-2 mt-1">
										<span class="text-black">Mystery</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Political"
										class="mr-2 mt-1"> <span class="text-black">Political</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Romance" class="mr-2 mt-1">
										<span class="text-black">Romance</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Sci-fi" class="mr-2 mt-1">
										<span class="text-black">Science fiction</span>
									</label> <label for="s_lg" class="d-flex"> <input
										type="checkbox" name="genre" value="Thriller"
										class="mr-2 mt-1"> <span class="text-black">Thriller</span>
									</label> <br> <input type="submit"
										class="buy-now btn btn-sm btn-primary" value="Filter">
								</form>
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
	<script>
		function myFunction() {
			location.href = "/myaccount"
		};
	</script>
</body>
</html>
