package API.apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;  // we im
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

import static groovy.json.JsonOutput.prettyPrint;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class A06_HamcrestMatchers extends SpartanTestBase { //inheritance

    @Test

        public void extractAsResponse(){



      Response response =  given().accept(ContentType.JSON)
                .pathParam("id",5216)
                .when().get("/api/spartans/{id}")
                .then().assertThat()//increase readability
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .body("id" , is(5216))
                .body("name" , is("Sabine B41 Gr6"))
                .body("gender" , is("Female"))
                .body("phone" , is(33064201292L))// we can add L so Java can put as Int
                .extract().response();

                 //Get me Id information
        System.out.println("response.path(\"id\") = " + response.path("id"));






    }
}
