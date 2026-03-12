package API.apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class A02_PathParameter {

    @BeforeAll
     public static void BeforeMethod(){
        RestAssured.baseURI="http://34.226.136.145:8000";

    }
    //String SpartanBAseURL = "http://34.226.136.145:8000";

    @Test
   public void PathParameter(){


      Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 6987).     //getting id
                when().get("/api/spartans/{id}");   //path param
        int statusCode = response.getStatusCode();
        System.out.println("statusCode = " + statusCode);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json",response.contentType());
        System.out.println("contentType = " + response.contentType());
        //Assertions.assertEquals(ContentType.JSON.toString(),response.contentType()); -->
        System.out.println(response.prettyPrint());
       // response.prettyPrint();


        // Response response = RestAssured.get(RestAssured.baseURI + "/api/spartans/6987");



//        int statusCode = response.getStatusCode();
//        Assertions.assertEquals(200, statusCode);
//        String contentType = response.contentType();
//        Assertions.assertEquals("application/json", contentType);
//
//        System.out.println(response.prettyPrint());


    }
}
