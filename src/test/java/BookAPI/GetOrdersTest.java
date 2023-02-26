package BookAPI;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
//wildcard

public class GetBookTest {

    public GetBookTest(){}

    @Test
    public void testGetListBooks(){

       baseURI="https://simple-books-api.glitch.me";
       basePath="/orders";

       Response response = given().header("authorization","5d64e7ca87b1c56b64f5b3b1432136db57f2dd40d0af91af5d439b8b3f06a902")
               .get().then()
               .statusCode(200)
               .extract().response();
      //  Instead of using header, you can use.auth().oauth2(“yourToken”)

        response.prettyPrint();

        //deseriliaziation
        List<Map<String,Object>> books = response.as(new TypeRef<List<Map<String, Object>>>() {});
        System.out.println(books.size());

        Assert.assertEquals(3,books.size());

        String firstCustomerName=books.get(0).get("customerName").toString();
        Assert.assertTrue(firstCustomerName.equals("Perry Wisoky"));
    }
}
