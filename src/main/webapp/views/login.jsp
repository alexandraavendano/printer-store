<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <title>Log in</title>
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
                        <li> <a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li> <a href="${pageContext.request.contextPath}/about">About</a></li>
                        <li> <a href="#">Services</a> </li>
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

        <div class="container logInContainer">
            <h3>Sign In</h3>
            <div class="container bg-light border">
                <form action="./login" method="POST">
                    <div class="mb-3">
                        <label for="inputEmail" class="form-label" >Email address</label>
                        <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" name="email">
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" id="inputPassword"  name="password">
                    </div>
                    <button type="submit" class="btn btn-secondary ">Submit</button>
                </form>
            </div>

            <p>Welcome : ${employee.firstName} !</p>
        </div>

    </div>
</body>

</html>