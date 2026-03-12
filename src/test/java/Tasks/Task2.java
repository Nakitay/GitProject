package Tasks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utilities.HrTestBase;

import static io.restassured.RestAssured.given;

public class Task2 extends HrTestBase {

    @Test
   public void Test2() {
      Response response  = given().accept(ContentType.JSON)
                .pathParam("employee_id",1)
                .when().get("/countries/{employee_id}")
                .then()
                .statusCode(404)
                .extract().response();



    }
}
