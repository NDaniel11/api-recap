package BookAPI;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;

public class GetBookTest {

    @Test
    public void getSingleBookTest(){
        baseURI="https://simple-books-api.glitch.me";
        basePath="/books/1";

        Response response = given().get().then().statusCode(200).extract().response();
//                  Response response = given().get().then().statusCode(200).extract().response();
       // response.prettyPrint();

        //Validate the price is more than 5$ in the response
        Map<String,Object> bookInfo = response.as(new TypeRef<Map<String, Object>>() {});

        double bookPrice =Double.parseDouble(bookInfo.get("price").toString());

        Assert.assertTrue(bookPrice>5);


    }
}
