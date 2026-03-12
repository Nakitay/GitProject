package utilities;

import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.baseURI;

public class BookitToken {

    @BeforeEach
    public void BeforeMethod() {

        baseURI = "https://api.qa.bookit.cydeo.com";
    }
}
