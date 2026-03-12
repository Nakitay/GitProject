package API.apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import static io.restassured.RestAssured.given;
import static java.lang.Math.log;

public class A09_Spartan_POST {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://34.226.136.145:8000";
    }

    @Test
    void PostRequest_Create() {

        String requestBody = "{\n" +
                "\"gender\":\"Female\",\n" +
                "\"name\":\"Nargiza\",\n" +
                "\"phone\":1234567890\n" +
                "}";


        JsonPath jsonPath = given().log().all().accept(ContentType.JSON)//API I need JSON response
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when().post("/api/spartans")
                .then()
                .statusCode(201)
                .contentType("application/json")
                .extract().jsonPath();

        String expectedMessage = "A Spartan is Born!";


        Assertions.assertEquals(expectedMessage, jsonPath.getString("success"));
        Assertions.assertEquals("Nargiza", jsonPath.getString("data.name"));
        Assertions.assertEquals("Female", jsonPath.getString("data.gender"));
        Assertions.assertEquals(1234567890, jsonPath.getLong("data.phone"));

        //Get me id that we POST as Spartan

        System.out.println(jsonPath.getInt("data.id"));


    }
/*
{
    "success": "A Spartan is Born!",
    "data": {
        "id": 6998,
        "name": "Nargiza",
        "gender": "Female",
        "phone": 1234567890
    }
}
 */


    @Test
    public void SpartanAsPojo() {

        Spartan spartanBody  = new Spartan();
        spartanBody.setName("Nargiza");
        spartanBody.setGender("Female");
        spartanBody.setPhone(1234567890);
        System.out.println(spartanBody);


    }
}













