package API.apiTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;

import java.util.List;
import java.util.Map;

public class A07_JSonPathCollections_Deserialization extends SpartanTestBase {

    @Test
    void jsonToMap() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 6987)
                .when().get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();

        //first Way ---> Response.As() ---> Map


        Map<String, Object> spartanMap = response.as(Map.class);
        System.out.println("spartanMap = " + spartanMap);


        //id is 
        assertEquals(6987, spartanMap.get("id"));
        //name is 
        assertEquals("Nargiza", spartanMap.get("name"));
        assertEquals("Female", spartanMap.get("gender"));
        assertEquals(1234567890, spartanMap.get("phone"));


// FIRST WAY --> JSONPATH.GETMAP() ---->MAP
        JsonPath jsonPath = response.jsonPath();
        Map<String, Object> spMap = jsonPath.getMap("");
        System.out.println("spMap = " + spMap);
        assertEquals(6987, spartanMap.get("id"));
        //name is
        assertEquals("Nargiza", spMap.get("name"));
        assertEquals("Female", spMap.get("gender"));
        assertEquals(1234567890, spMap.get("phone"));


    }

    @Test
    public void jsonToList() {

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .contentType("application/json")
                .extract().response();

//FIRST WAY ---->USING RESPONSE.AS(list.class);
// SECOND WAY ----> jsonPath.getList("")

        List<Map<String, Object>> spartanListAsMAp = response.as(List.class);
        for (Map<String, Object> eachSpartan : spartanListAsMAp) {

            System.out.println("eachSpartan = " + eachSpartan);

        }

        System.out.println("----------------------JsonPath.GetList---------------------------");

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> listAsMap = jsonPath.getList("");
        for (Map<String, Object> EachSpartan : listAsMap) {
            System.out.println("EachSpartanAsObjectMap = " + EachSpartan);

        }


    }

    //GPATH SYNTAX
    @Test
    void partialJsonToMap() {

        Response response = given().accept(ContentType.JSON)
                .when().get("api/spartans")
                .then().statusCode(200)
                .extract().response();


        JsonPath jsonPath = response.jsonPath();
         Map<Object, Object> firstSpartanAsMAp = jsonPath.getMap("[0]");
        System.out.println("firstSpartanAsMAp = " + firstSpartanAsMAp);

    }
}
