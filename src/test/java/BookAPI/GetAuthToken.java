package BookAPI;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAuthToken {

    public static String getToken(){
        baseURI="https://simple-books-api.glitch.me";
        basePath="/api-clients/";

        //can I send Post request and get the token from response body?? ==> YES

        Response response = given().accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "   \"clientName\": \"David\",\n" +
                        "   \"clientEmail\": \"dani11@gmail.com\"\n" +
                        "}")
                .when().post().then().statusCode(201)
                .extract().response();

        return response.jsonPath().get("accessToken");
    }
}
