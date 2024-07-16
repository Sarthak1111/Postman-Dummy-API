About:-

This is the Book Management API for adding, retreiving, updating and deleting the book details via APIs.
The API is available at https://simple-books-api.glitch.me


Technologies Used:-

-java 9+

-TestNG

-RestAssured


Prequisites:-

-Java 9+ 

-Eclipse

-TestNG

-Maven


Dependencies:-


-rest-assured

-json-path

-json

-gson

-testng

-scribejava-apis

-json-schema-validator

-xml-schema-validator


How to Run:-

1. Postman: Download the collection in local and import the file in postman. Add valid and invalid global variable in environment.

2. Eclipse: Clone the repo> add dependencies> open testng.xml file> right click> Run As> TestNG Suite > All test will pass


Methods used AND HTTPS Status codes:-

POST

1. Adding a Book with valid inputs- Status Code: 200

2. Adding a Book with invalid inputs- Stutus COde: 400

GET

1. Retrieving a Book with valid book IDs- Status Code: 200

2. Retrieving a Book with invalid book IDs- Status Code: 404

PUT

1. Updating Book Details with valid data- Status Code: 200

2. Updating Book Details with invalid data- Status Code: 400

DELETE

1. Deleting a Book with valid book IDs- Status Code: 204

2. Deleting a Book with invalid book IDs- Status Code: 404


Author Contact:-

LinkedIn: https://www.linkedin.com/in/sarthakkaushik1111/

Github: https://github.com/Sarthak1111

License:-

Copyright © 2024 Sarthak Kaushik.
