package API.apiTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Spartan;
import utilities.SpartanTestBase;

import java.util.List;

import static io.restassured.RestAssured.given;

public class A08_POJO extends SpartanTestBase {

    @Test
    public void getSingleSpartan() {

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 5214)
                .when().get("api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();


        JsonPath jsonPath = response.jsonPath();
        Spartan sp = jsonPath.getObject("", Spartan.class);
        System.out.println(sp);

        System.out.println("sp.getName() = " + sp.getName());
        System.out.println(sp.getId());
        System.out.println(sp.getGender());
        System.out.println(sp.getPhone());
    }

    @Test
    public void getAllSpartans() {
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .when().get("api/spartans/")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().jsonPath();

        List<Spartan> AllSpartanAsPojo = jsonPath.getList("", Spartan.class);
        for (Spartan eachSpartan : AllSpartanAsPojo) {
            System.out.println("eachSpartan = " + eachSpartan);

        }
    }

    @Test
    public void partiallyPojo() {
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .when().get("api/spartans/")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().jsonPath();

        Spartan sp = jsonPath.getObject("[0]", Spartan.class);
        System.out.println("sp = " + sp);


    }
}






/*
What POJO Really Means
POJO (Plain Old Java Object) is: 👉 A simple Java class used to hold data.
It has:variables (fields)/getters/setters/sometimes constructors

public class SSpartan{
    private ]int id;
    private String name;
    private String gender;
    private long phone;

//getter + setter
// ToString
//Constructor
 */