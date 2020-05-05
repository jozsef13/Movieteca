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

				<div class="col-6 col-md-4 order-3 order-md-3 text-right">
					<div class="site-top-icons">
						<ul>
							<li><a href="/myaccount.jsp"><span class="icon icon-person"></span></a></li>
							<li><a href="#"><span class="icon icon-heart-o"></span></a></li>
							<li><a href="/cart/<c:out value = "${cart.id}" />"
								class="site-cart"> <span class="icon icon-shopping_cart"></span>
								<span class="count"> 
									<c:choose>
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
						<a href="/index.jsp">Home</a> <span class="mx-2 mb-0">/</span> <a
							href="/cart.jsp">My Account</a> <span class="mx-2 mb-0">/</span>
						<strong class="text-black">Edit movie list</strong>
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
									<h2 class="text-black h5">Your list</h2>
								</div>
								<div class="d-flex">
									<div class="dropdown mr-1 ml-md-auto">
										<a href="editmovie.jsp" class="buy-now btn btn-sm btn-primary">Add
											movie</a>
										<button type="button"
											class="btn btn-secondary btn-sm dropdown-toggle"
											id="dropdownMenuOffset" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">Latest</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuOffset">
											<a class="dropdown-item" href="#">TV-Shows</a> <a
												class="dropdown-item" href="#">Movies</a> <a
												class="dropdown-item" href="#">Documentaries</a>
										</div>
									</div>
									<div class="btn-group">
										<button type="button"
											class="btn btn-secondary btn-sm dropdown-toggle"
											id="dropdownMenuReference" data-toggle="dropdown">Reference</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuReference">
											<a class="dropdown-item" href="#">Relevance</a> <a
												class="dropdown-item" href="#">Name, A to Z</a> <a
												class="dropdown-item" href="#">Name, Z to A</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#">Most bought</a> <a
												class="dropdown-item" href="#">Most rented</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row mb-5">

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/singlemovie.jsp"><img
										style="width: 500px; height: 300px;" src="/images/movie.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/singlemovie.jsp"><img
										style="width: 500px; height: 300px;" src="images/shrek.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="/cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/shop-single.jsp"><img
										style="width: 500px; height: 300px;" src="/images/shrek.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="/cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/shop-single.jsp"><img
										style="width: 500px; height: 300px;" src="images/shrek.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="/cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/shop-single.jsp"><img
										style="width: 500px; height: 300px;" src="images/shrek.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="/cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
								<div class="block-4 text-center border">
									<figure class="block-4-image"> <a
										href="/shop-single.jsp"><img
										style="width: 500px; height: 300px;" src="images/shrek.jpg"
										alt="Image placeholder" class="img-fluid"></a> </figure>
									<div class="block-4-text p-4">
										<h3>
											<a href="/singlemovie.jsp">Avengers</a>
										</h3>
										<p>
											<strong class="text-primary h4">$5.00 / $20.00</strong>
										</p>
										<p>
											<a href="/cart.jsp" class="buy-now btn btn-sm btn-primary">Edit
												movie</a>
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row" data-aos="fade-up">
							<div class="col-md-12 text-center">
								<div class="site-block-27">
									<ul>
										<li><a href="#">&lt;</a></li>
										<li class="active"><span>1</span></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">&gt;</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-3 order-1 mb-5 mb-md-0">
						<div class="border p-4 rounded mb-4">
							<h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
							<ul class="list-unstyled mb-0">
								<li class="mb-1"><a href="#" class="d-flex"><span>TV-Shows</span>
										<span class="text-black ml-auto">(220)</span></a></li>
								<li class="mb-1"><a href="#" class="d-flex"><span>Movies</span>
										<span class="text-black ml-auto">(550)</span></a></li>
								<li class="mb-1"><a href="#" class="d-flex"><span>Documentaries</span>
										<span class="text-black ml-auto">(124)</span></a></li>
							</ul>
						</div>

						<div class="border p-4 rounded mb-4">
							<div class="mb-4">
								<h3 class="mb-3 h6 text-uppercase text-black d-block">Filter
									by Price</h3>
								<div id="slider-range" class="border-primary"></div>
								<input type="text" name="text" id="amount"
									class="form-control border-0 pl-0 bg-white" disabled="" />
							</div>

							<div class="mb-4">
								<h3 class="mb-3 h6 text-uppercase text-black d-block">Genre</h3>
								<label for="s_sm" class="d-flex"> <input type="checkbox"
									class="mr-2 mt-1"> <span class="text-black">Action</span>
								</label> <label for="s_md" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Adventure</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Comedy</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Crime</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Drama</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Fantasy</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Historical</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Horror</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Mystery</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Political</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Romance</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Science fiction</span>
								</label> <label for="s_lg" class="d-flex"> <input
									type="checkbox" class="mr-2 mt-1"> <span
									class="text-black">Thriller</span>
								</label>

							</div>

							<div class="mb-4">
								<h3 class="mb-3 h6 text-uppercase text-black d-block">Availability</h3>
								<a href="#" class="d-flex color-item align-items-center"> <span
									class="bg-success color d-inline-block rounded-circle mr-2"></span>
									<span class="text-black">On stock</span>
								</a> <a href="#" class="d-flex color-item align-items-center">
									<span
									class="bg-warning color d-inline-block rounded-circle mr-2"></span>
									<span class="text-black">Few left</span>
								</a> <a href="#" class="d-flex color-item align-items-center">
									<span
									class="bg-danger color d-inline-block rounded-circle mr-2"></span>
									<span class="text-black">Not on stock</span>
								</a>
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
