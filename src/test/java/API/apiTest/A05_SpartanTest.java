package API.apiTest;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class A05_SpartanTest {


    @BeforeEach
    public void BeforeMethod() {

        baseURI = "http://34.226.136.145:8000";

    }

    @Test

    public void TestMethod() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 5216)
                .when().get("/api/spartans/{id}");
        response.prettyPrint();

        //status code 200
        assertEquals(200, response.statusCode());

        //contentType is JSON
        assertEquals(ContentType.JSON.toString(), response.contentType());


        //Create Json Path Object


        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");
        System.out.println(id);
        assertEquals(5212,"id");
        String name = jsonPath.getString("name");
        System.out.println(name);

        String gender = jsonPath.getString("gender");
        System.out.println(gender);
       long phone = jsonPath.getLong("phone");
        System.out.println(phone);

    }

    @Test
    public void GetAllSpartans(){

        Response response = when().get("/api/spartans/");
       // response.prettyPrint();
       JsonPath jsonPath = response.jsonPath();
       // Get me first spartan ID

         int firstSpartanId  = jsonPath.get("id[1]");
        System.out.println(firstSpartanId);
        //Get me first Spartan name
        String firstSpartanName  = jsonPath.get("name[1]");
        System.out.println(firstSpartanName);

         //Get me last spartan names
        String LastSpartanName = jsonPath.get("name[-1]");
        System.out.println(LastSpartanName);

        //Get All spartan names
        List<String> allNames = jsonPath.getList("name");
        System.out.println(allNames);
        //get me all ID
         List<Object> allId = jsonPath.getList("id");
        System.out.println(allId);


    }
}


