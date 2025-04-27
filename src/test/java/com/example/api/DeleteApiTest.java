import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteApiTest extends BaseTest {

    @Test
    public void testDeleteResource() {
        // Define the resource ID to delete
        int resourceId = 1;

        // Send the DELETE request and validate the response
        given()
                .when()
                .delete("/resources/" + resourceId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Resource deleted successfully"));
    }

    @Test
    public void testDeleteNonExistentResource() {
        // Define a non-existent resource ID
        int nonExistentResourceId = 999;

        // Send the DELETE request and validate the response
        given()
                .when()
                .delete("/resources/" + nonExistentResourceId)
                .then()
                .statusCode(404)
                .body("error", equalTo("Resource not found"));
    }
}