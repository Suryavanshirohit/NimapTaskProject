# NimapTaskProject
  CRUD operation task

Machine Test: Category & Product Management with Spring Boot
This project demonstrates the implementation of a RESTful application using Spring Boot to manage Category and Product entities. It includes CRUD operations, database integration, and a one-to-many relationship between categories and products.
Functional Requirements
1. Category Management APIs
API Endpoint	HTTP Method	Description
/restapi/categories?page={pageNumber}	GET	Fetch all categories with pagination.
/restapi/add/category	POST	Create a new category.
/restapi/category/{id}	GET	Fetch a category by ID.
/restapi/category/{id}	PUT	Update a category by ID.
/restapi/category/{id}	DELETE	Delete a category by ID.
2. Product Management APIs
API Endpoint	HTTP Method	Description
/restapi/products?page={pageNumber}	GET	Fetch all products with pagination.
/restapi/add/product	Create a new product.
/restapi/product/{id}	GET	Fetch a product by ID.
/restapi/product/{id}	PUT	Update a product by ID.
/restapi/delete/product/{id}	DELETE	Delete a product by ID.
3. Additional Requirements
Relationship: Establish a one-to-many relationship between Category and Product:
One Category → Multiple Products.
Server-side Pagination for retrieving categories and products.

cd NimapTask
