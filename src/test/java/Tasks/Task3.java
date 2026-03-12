package Tasks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import utilities.HrTestBase;

import static groovy.json.JsonOutput.prettyPrint;
import static io.restassured.RestAssured.given;
import static java.lang.Math.log;

public class Task3 extends HrTestBase {

    @Test
    void task3() {

        given().contentType(ContentType.JSON)
                .when()
                .get("/regions/1")
                .then()
                .statusCode(200) // assertions
                .body("region_name", Matchers.is("Europe"))
                .header("Date", Matchers.notNullValue())
                .header("Transfer-Encoding", Matchers.is("chunked"))


                .log().all();

    }
}
