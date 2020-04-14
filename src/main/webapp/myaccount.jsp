<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>MOVIETECA </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
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

              <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                <div class="site-logo">
                  <a href="index.jsp" class="js-logo-clone">MOVIETECA</a>
                </div>
              </div>

              <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                <div class="site-top-icons">
                  <ul>
                    <li><a href="/provider/1"><span class="icon icon-person"></span></a></li>
                    <li><a href="#"><span class="icon icon-heart-o"></span></a></li>
                    <li>
                      <a href="cart.jsp" class="site-cart">
                        <span class="icon icon-shopping_cart"></span>
                        <span class="count">0</span>
                      </a>
                    </li>
                    <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                  </ul>
                </div>
              </div>

            </div>
          </div>
        </div>

        <nav class="site-navigation text-right text-md-center" role="navigation">
          <div class="container">
            <ul class="site-menu js-clone-nav d-none d-md-block">
              <li class="nav-item"><a href="index.jsp">Home</a></li>
              <li class="nav-item"><a href="movies.jsp">Movies</a></li>
              <li class="nav-item"><a href="contact.jsp">Contact</a></li>
              <li class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                <form action="" class="site-block-top-search">
                  <span class="icon icon-search2"></span>
                  <input type="text" class="form-control border-0" placeholder="Search">
                </form>
              </li>
            </ul>
          </div>
        </nav>

    </header>

    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0"><a href="index.jsp">Movies</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">My Account</strong></div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-5">
            <img style="width:500px;height:300px;" src="images/profilepicture.jpg" alt="Image placeholder" class="img-fluid" >
          </div>
          <div class="col-md-6">
            <u><h2 class="text-black">Account Info</h2></u>
            <p>Username: ${provider.userName}</p>
            <p>Last Name: ${provider.lastName }</p>
            <p>First Name: ${provider.firstName }</p>
            <p>E-Mail: ${provider.email }</p>
            <p>Birthdate: ${provider.birthDate }</p>
            <p>Address: ${provider.city}, ${provider.country }</p>
          </div>
        </div>
          <br>
          <p>
          <a href="editprofile.jsp" class="buy-now btn btn-sm btn-primary">Edit profile</a>
          <a href="editmovielist.jsp" class="buy-now btn btn-sm btn-primary">Edit movie list</a></p>
      </div>


      <div class="container">
        <div class="row">
          <div class="col-md-6">

            <i><p><h2> Last movies rented:</p></h2></i>
            <p> Movie1 </p>
            <p> Movie1 </p>
            <p> Movie1 </p>
            <p> Movie1 </p>
            <p> Movie1 </p>

          </div>

          <div class="col-md-6">
            <i><p><h2> Last movies bought:</p></h2></i>
            <p> Movie2 </p>
            <p> Movie2 </p>
            <p> Movie2 </p>
            <p> Movie2 </p>
            <p> Movie2 </p>
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
