# Printer Store

An entrepreneur wants to have a virtual store to offer advertising products such as mugs, stamps, t-shirts, and many more customizable objects.

## Features
There are three initial roles for this project:

### Users:
- Can create an account on the page.
- On the home page, they will be able to see the list of products
- For each product they can choose the number of printable object that they want, add a photo to personalize the product, or add a clear description of the design they want.
- Can add products to a shopping cart.
- By reviewing the order they will be able to see a summary of the total order price and delete product that they no longer want.
- After the order was sent the user can check the order and the order status.

### Employee
- Each of the employees will have an account
- They can access the orders found in the system.
- They can download images that users have initially uploaded to the order.
- They can update the order status.
- They can update the item status independently.

### Administrator:
- They can create, read, and update products.
- They can create, read, and delete employees.
- They can see all the products as client, but they will not have the checkout button available.

## Tech

This project uses a number of open source projects to work properly:

- [ReactJS](https://reactjs.org/)
- [Spring](https://spring.io/)
- [React Bootstrap](https://react-bootstrap.github.io/)
- [React Router](https://reactrouter.com/)
- [Bootstrap 5.1](https://getbootstrap.com/docs/5.1/getting-started/introduction/)
- [Junit](https://junit.org/junit4/)
- [MariaDB](https://mariadb.org/)
- [H2](https://www.h2database.com/html/main.html)
- [Maven](https://maven.apache.org/)
- [Guava](https://opensource.google/projects/guava)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT](https://jwt.io/)

## Installation

This application requires [Node.js](https://nodejs.org/) v10+ to run.

1. Install the maven dependencies
2. Run `producttype.sql`, `role.sql` and `state.sql` in the `printer-store/deploymentResources/insertQueries` folder.
3. Start the service running the `src/main/java/com/practicespring/printerstore/BasicSpringApplication.java`
4. Check out the postman and the different examples of request that you can make.

## FrontEnd
[Deploy FrontEnd](https://github.com/alexandraavendano/printer-store-front) for full functionality.