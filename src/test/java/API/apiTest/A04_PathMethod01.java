package API.apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class A04_PathMethod01 {

    @BeforeAll
    public static void BeforeMethod() {
        RestAssured.baseURI = "http://34.226.136.145:8000";

    }

    @Test
    public void Test() {


        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 6987).
                when().get("api/spartans/{id}");


        response.prettyPrint();
// correct assertions
        assertEquals(200, response.statusCode());           // status
        assertEquals("application/json", response.contentType()); // content type

        int id = response.path("id");
        System.out.println(id);
        assertEquals(6987, id);


        String name = response.path("name");
        System.out.println(name);
        assertEquals("Nargiza", name);

        String gender = response.path("gender");
        System.out.println(gender);
        assertEquals("Female", gender);

        int phone = response.path("phone");
        System.out.println(phone);
        assertEquals(1234567890, phone);
    }

    @Test
    public void getAllSpartans() {
        Response response = when().get("/api/spartans");
        response.prettyPrint();


        // Get me first Spartan id

        System.out.println("response.path(\"id[0]\") = " + response.path("id[0]"));

        //get me second spartan name
        System.out.println("response.path(\"name[1]\") = " + response.path("name[1]"));

        //get me last spartan name
        System.out.println("response.path(\"name[-1]\") = " + response.path("name[-1]"));

// get me all spartan names
       List<String> allnames =  response.path("name");
        System.out.println("--------names-------------");
        System.out.println(allnames);

       List<Integer> allId =  response.path("id");
        System.out.println(allId);
    }
}

