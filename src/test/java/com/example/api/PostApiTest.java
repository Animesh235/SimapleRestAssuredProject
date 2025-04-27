import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApiTest extends BaseTest {

    @Test
    public void testCreateResource() {
        String requestBody = "{ \"name\": \"New Resource\", \"value\": \"Resource Value\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/resources");

        response.then()
                .statusCode(201)
                .body("name", equalTo("New Resource"))
                .body("value", equalTo("Resource Value"));
    }

    @Test
    public void testCreateResourceWithInvalidData() {
        String requestBody = "{ \"name\": \"\", \"value\": \"Resource Value\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/resources");

        response.then()
                .statusCode(400)
                .body("error", equalTo("Invalid input"));
    }
}