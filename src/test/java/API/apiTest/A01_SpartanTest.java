package API.apiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class A01_SpartanTest {


String spartanBaseUrl = "http://34.226.136.145:8000"; //create Global

    @Test
    public void GetAllSpartans() {//Command+N --> shortcut for Test annotation

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");//adding endpoint
         // shortcut Option+Enter



        //status code
    int statusCode = response.getStatusCode();
        System.out.println("statusCode = " + statusCode);
        Assertions.assertEquals(200,statusCode);


        //content TYPE
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);
        Assertions.assertEquals("application/json" , contentType);


        System.out.println("--------------RESPONSE AS A STRING------------------------");
        //print BODY
        System.out.println(response.asString());

        System.out.println("------------------response Pretty Print -----------------------");

        System.out.println(response.prettyPrint()); // give a format to easy to read

    }

}

