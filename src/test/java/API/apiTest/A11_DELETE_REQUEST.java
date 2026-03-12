package API.apiTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

import static io.restassured.RestAssured.given;

public class A11_DELETE_REQUEST extends SpartanTestBase {

    /*
    "DELETE is an HTTP method used to remove a resource from the server.
     In API testing we send a DELETE request with an
     ID and verify the response status code, usually 204,
     and confirm the resource no longer exists."
    for DELETE you usually do NOT prepare a body.
In Rest Assured, most DELETE requests only need the resource ID, not a request body.
     */

    @Test
    public void spartanDElETE() {



            given()
                    .pathParam("id",7001)

                    .when()
                    .delete("/api/spartans/{id}")

                    .then()
                    .statusCode(204);//204 or 404 // not found because its deleted


        //GET request to see 404 not found
        given().accept(ContentType.JSON)
                .pathParam("id" , 7001)
                .when().get("/api/spartans/{id}")
                .then().statusCode(404);
        }
    }

