import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiTest extends BaseTest {

    @Test
    public void testUpdateResource() {
        // Define the resource ID to update
        int resourceId = 1;

        // Create the request body
        String requestBody = "{ \"name\": \"Updated Name\", \"status\": \"active\" }";

        // Send the PUT request and validate the response
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/resources/" + resourceId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Name"))
                .body("status", equalTo("active"))
                .extract()
                .response();

        // Additional assertions can be added here if needed
    }

    @Test
    public void testUpdateNonExistentResource() {
        // Define a non-existent resource ID
        int nonExistentResourceId = 999;

        // Create the request body
        String requestBody = "{ \"name\": \"Non-existent\", \"status\": \"inactive\" }";

        // Send the PUT request and validate the response
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/resources/" + nonExistentResourceId)
                .then()
                .statusCode(404); // Expecting a 404 Not Found response
    }
}