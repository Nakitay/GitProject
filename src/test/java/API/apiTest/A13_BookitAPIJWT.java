package API.apiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilities.BookitToken;

import static io.restassured.RestAssured.given;

public class A13_BookitAPIJWT extends BookitToken {

    /*
    team_leader_email= lfinnisz@yolasite.com
    team_leader_password= lissiefinnis
     */
    @Test
    public void Test1() {


        JsonPath jsonPath =
                given()
                        // .baseUri("https://api.qa.bookit.cydeo.com")
                        .queryParam("email", "lfinnisz@yolasite.com")
                        .queryParam("password", "lissiefinnis")
                        .when()
                        .get("/sign")
                        .then()
                        .statusCode(200)
                        .extract().jsonPath();

        String accessToken = "Bearer " + jsonPath.getString("accessToken");
        System.out.println("accessToken = " + accessToken);


        //send Request /api/users/me endpoint to get infor about token owner
        Response response = given().accept(ContentType.JSON)
                // .baseUri("https://api.qa.bookit.cydeo.com")
                .header("Authorization", accessToken)
                .when()
                .get("/api/users/me")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        //response.prettyPrint();
/*
✅ Simple rule

Method	Shows
prettyPrint()	Response body only
log().all()	Request + response
log().body()	Body only
 */

    }


}

