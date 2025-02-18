# NimapTaskProject

📌 NimapTaskProject
🛠 CRUD Operations in Spring Boot
📖 Overview
This project demonstrates a RESTful API using Spring Boot, managing Category and Product entities with a one-to-many relationship. It includes CRUD operations, pagination, and database integration.

📌 Features
✔ Category & Product Management
✔ RESTful APIs
✔ Pagination Support
✔ Spring Data JPA & Hibernate

🛠 API Endpoints
🔹 Category Management APIs
Endpoint	HTTP Method	Description
/restapi/categories?page={pageNumber}	GET	Fetch all categories (paginated)
/restapi/add/category	POST	Create a new category
/restapi/category/{id}	GET	Fetch a category by ID
/restapi/category/{id}	PUT	Update a category by ID
/restapi/category/{id}	DELETE	Delete a category by ID
🔹 Product Management APIs
Endpoint	HTTP Method	Description
/restapi/products?page={pageNumber}	GET	Fetch all products (paginated)
/restapi/add/product	POST	Create a new product
/restapi/product/{id}	GET	Fetch a product by ID
/restapi/product/{id}	PUT	Update a product by ID
/restapi/delete/product/{id}	DELETE	Delete a product by ID
