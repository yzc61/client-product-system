# client-product-system

The web application should support the following features:
● A client can create new product in the service
● A client can modify their own products
● A client can delete their own products
● A client can view all products in the service

First I decided with properties of client and product. A client has id,name and password. A product id,name, owner and version.

Step 1-) Creating app initializer by using AbstractAnnotationConfigDispatcherServletInitializer class.
Step 2-) Create config files to define beans (jdbcTemplate, viewResolver, datasource).
Step 3-) Create the client and product classes in "api" package.
Step 4-) Create rowmapper for client and product to use with jdbctemplate in database operations.
Step 5-) Create controller class in "controller" package and mappings.
Step 6-) Create service class in "service" package to handle logics in controller
Step 7-) Create clientdao and productdao classes to handle database operations wtih jdbctemplate.

● A client can view all products in the service

Get connection with database (controller ==> service ==> productdao ==> productdao function which brings all data) and make a table in jsp file to show all the products.

I also make same table for the client's (which login) products by adding "update" and "delete" button. Also added "add" button to create new product.

● A client can create new product in the service

In "add page" the client just enter product name and version. product owner is added by backend code automatically and id is added by MySQL automatically. After submit the values directle return the client product list. (to prevent multiple addings)

● A client can modify their own products

In "update page" the client can modify product name and version after submit the values directle return the client product list.

● A client can delete their own products

For deleting products user just click the delete button. Every product has a button for delete.
