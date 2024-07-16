package API.Rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Book {

    // Define base URL
    String BASE_URL = "http://bookstore-url/";
    String validBookId = "1232";
    String invalidBookId = "!@@12321";
    
   //=====================ADDING BOOK===========================
    @Test
    public void testAddBookWithValidInput() {
        // Define your valid book JSON payload
        String validBookPayload = "{ \"title\": \"\"Sample Book\","
        		+ " \"author\": \"John Doe\", "
        		+ "\"isbn\": \"1234567890\" }";

        given()
            .contentType(ContentType.JSON)
            .body(validBookPayload)
        .when()
            .post(BASE_URL + "/books")
        .then()
            .statusCode(200); // Assuming 200 is the success status code
    }

    @Test
    public void testAddBookWithInvalidInput() {
        // Define your invalid book JSON payload
        String invalidBookPayload = "{ \"title\": \"\", \"author\": \"\", \"isbn\": \"1234567890\" }";

        given()
            .contentType(ContentType.JSON)
            .body(invalidBookPayload)
        .when()
            .post(BASE_URL + "/books")
        .then()
            .statusCode(400); // Assuming 400 is the status code for bad request
    }

    //=========================RETRIEVING BOOK===============================
    @Test
    public void testRetrieveBookWithValidId() {

        given()
            .pathParam("bookId", validBookId)
        .when()
            .get(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(200)
            .body("title", equalTo("Expected Book Title"));
    }

    @Test
    public void testRetrieveBookWithInvalidId() {

        given()
            .pathParam("bookId", invalidBookId)
        .when()
            .get(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(404); // Assuming 404 for not found
    }
    
    //========================Update Book Details===============================
    @Test
    public void testUpdateBookWithValidData() {
        String updatedBookPayload = "{ \"title\": \"Updated Book Title\", \"author\": \"Jane Doe\", \"isbn\": \"0987654321\" }";

        given()
            .contentType(ContentType.JSON)
            .pathParam("bookId", validBookId)
            .body(updatedBookPayload)
        .when()
            .put(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(200);
    }

    @Test
    public void testUpdateBookWithInvalidData() {
        String invalidBookPayload = "{ \"title\": \"\", \"author\": \"\", \"isbn\": \"0987654321\" }";

        given()
            .contentType(ContentType.JSON)
            .pathParam("bookId", validBookId)
            .body(invalidBookPayload)
        .when()
            .put(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(400); // Assuming 400 for bad request
    }
    
    
    //========================DELETING BOOK===========================
    @Test
    public void testDeleteBookWithValidId() {

        given()
            .pathParam("bookId", validBookId)
        .when()
            .delete(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(204); // Assuming 204 for successful deletion
    }

    @Test
    public void testDeleteBookWithInvalidId() {

        given()
            .pathParam("bookId", invalidBookId)
        .when()
            .delete(BASE_URL + "/books/{bookId}")
        .then()
            .statusCode(404); // Assuming 404 for not found
    }

}