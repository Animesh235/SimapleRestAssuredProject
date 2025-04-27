import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://api.example.com"; // Replace with your API base URI
        RestAssured.port = 80; // Replace with your API port if necessary
        RestAssured.basePath = "/v1"; // Replace with your API base path if necessary
    }
}