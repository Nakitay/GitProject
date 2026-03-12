package API.apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static javax.management.Query.and;

public class A03_QueryParamTest {

    @BeforeAll
    public static void BeforeMethod() {
        RestAssured.baseURI = "http://34.226.136.145:8000";
    }

    @Test
    public void Test(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("name", "J")
                    .queryParam("gender", "Female").
        //getting id
                        when().get("/api/spartans/search");
        int statusCode = response.getStatusCode();
        System.out.println("statusCode = " + statusCode);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json",response.contentType());
        System.out.println("contentType = " + response.contentType());
        //Assertions.assertEquals(ContentType.JSON.toString(),response.contentType()); -->

        System.out.println(response.prettyPrint());
    }
}
