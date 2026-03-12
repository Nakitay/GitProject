package API.apiTest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import utilities.SpartanAuthenticationTestBAse;

import static io.restassured.RestAssured.given;

public class A12_BasicAuth extends SpartanAuthenticationTestBAse {

    @Test
    public void basicAuthentication() {

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().get("api/spartans/")
                .then()
                .statusCode(401)
                .body("error", Matchers.is("Unauthorized"))//HamcrestMatchers
                .extract().response();

    }
//second one is gonna be as a user


    @Test
   public void GetRequestAsAUser() { //providing a password and login
        given().accept(ContentType.JSON)
                .auth().basic("user","user")
                .when().get("/api/spartans")
                .then()
                .statusCode(200);
    }

    @Test
   public void deleteRequestAsUser() {
        given().pathParam("id" , 441)
                .auth().basic("user","user")
                .when()
                .delete("api/spartans/{id}")
                .then()
                .statusCode(403)
                .body("error",Matchers.is("Forbidden"))
                .extract().response();



    }






}

