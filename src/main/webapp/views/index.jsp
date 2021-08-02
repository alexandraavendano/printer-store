<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="./styles/home.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <title>BillBoard</title>
</head>

<body>
  <div class="container">

    <!-- Header content menu -->
    <header class="menu_container">
      <div class="menu_item">
        <div class="logo_container">
          <img src="./images/logo.jpg" alt="BillBoard logo" id="logo">
        </div>
      </div>
      <div class="menu_item">
        <nav>
          <ul>
            <li> <a href="${pageContext.request.contextPath}/#">Home</a></li>
            <li> <a href="${pageContext.request.contextPath}/about">About</a></li>
            <li> <a href="${pageContext.request.contextPath}/#">Services</a> </li>
            <li> <a href="${pageContext.request.contextPath}/contact">Contact</a> </li>
            <li><a href="${pageContext.request.contextPath}/login"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
              <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            </svg></a></li>
            <li> <a><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart2" viewBox="0 0 16 16">
                <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
              </svg></a>
            </li>
          </ul>
        </nav>
      </div>
    </header>

    <!-- Carousel -->

    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="./images/banner_bus_stop.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="./images/banner_buildings.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="./images/stickers_vote.jpg" class="d-block w-100" alt="...">
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

    <!-- Products -->
    <div class="products_menu">
      <div class="row row-cols-1 row-cols-md-2 g-4">
        <div class="col">
          <div class="card">
            <img src="./images/pendon1_ojales.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut mollis et arcu volutpat dapibus. In id enim eu urna pellentesque sodales eu eu odio. Phasellus non odio ac orci consequat.</p>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="./images/pendon2.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ligula turpis, eleifend feugiat orci vel, aliquet gravida neque. Duis dictum.</p>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="./images/roll-up-banner.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ligula turpis, eleifend feugiat orci vel, aliquet gravida neque. Duis dictum.</p>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img src="./images/spider-banner1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
          </div>
        </div>
      </div>  
    </div>
    
  </div>
</body>

</html>