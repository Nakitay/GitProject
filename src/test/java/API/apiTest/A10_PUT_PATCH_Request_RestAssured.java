package API.apiTest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;


public class A10_PUT_PATCH_Request_RestAssured extends SpartanTestBase {

    @Test
    public void spartanPUT() {
//1. First Part — Preparing the Request Body
        //You are only preparing the request body.
        //Rest Assured will later convert this Map → JSON.
        Map<String, Object> putBody = new LinkedHashMap<>();
        putBody.put("name", "Nargiza PUT ");
        putBody.put("gender", "Female");
        putBody.put("phone", 1234567890l);
        System.out.println(putBody);

//2. Second Part — Sending the API Request
        //This is the actual API test execution using Rest Assured.
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", 7001)
                .body(putBody)
                .when().put("api/spartans/{id}")
                .then()
                .statusCode(204)
                .extract().response();


    }

/*
First we create a Map object to build the request body.
Rest Assured automatically converts the Map into JSON.
 Then we send a PUT request using given-when-then syntax and
 validate that the API returns status code 204.
 */

    @Test
    public void spartanPATCH() {
        Map<String, Object> patchBody = new LinkedHashMap<>();
        patchBody.put("name", "Nargiza patch");
        patchBody.put("gender","Female");
        patchBody.put("phone",1234567890l);
        System.out.println(patchBody);

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id" , 7001)
                .body(patchBody)
                .when().put("api/spartans/{id}")
                .then()
                .statusCode(204)
                .extract().response();



    }
}