package Tasks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import utilities.HrTestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Task01 extends HrTestBase {

    @Test
   public void test01(){

    Response response = given().accept(ContentType.JSON)

                .pathParam("country_id" ,"US")

                .when().get("/countries/{country_id}")
                .then()
                .statusCode(200)
                .body("country_id", Matchers.is("US"))
                .body("country_name" ,Matchers.is("United States of America"))
            .body("region_id", Matchers.is(2))
            .extract().response();

    response.prettyPrint();










    }
}
