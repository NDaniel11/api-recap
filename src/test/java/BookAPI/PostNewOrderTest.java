package BookAPI;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PostNewOrderTest {

    @Test
    public void postNewOrder(){
        baseURI="https://simple-books-api.glitch.me";
        basePath="/orders";

        Response response = given().auth().oauth2(GetAuthToken.getToken())
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "    \"bookId\": 1,\n" +
                        "    \"customerName\": \"Daniel N\"\n" +
                        "}")
                .when().post().then().statusCode(201)
                .extract().response();

        response.prettyPrint();

    }
}
