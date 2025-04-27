import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetApiTest extends BaseTest {

    @Test
    public void testGetUserById() {
        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String name = response.jsonPath().getString("name");
        String email = response.jsonPath().getString("email");

        // Assertions
        assertThat(name, equalTo("John Doe"));
        assertThat(email, equalTo("john.doe@example.com"));
    }

    @Test
    public void testGetAllUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", equalTo(10)); // Assuming there are 10 users
    }

    @Test
    public void testGetUserNotFound() {
        given()
                .pathParam("id", 999)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(404);
    }
}