package utilities;

import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.baseURI;

public class SpartanAuthenticationTestBAse {

    @BeforeEach
    public void BeforeMethod() {

        baseURI = "http://34.226.136.145:7000";
    }
}
