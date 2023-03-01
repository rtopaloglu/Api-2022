package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08_deneme extends JsonPlaceHolderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get01() {
        // 1. set the url
        spec.pathParams("first", "todos", "second",2);

        // 2. set the expected data
        Map<String, Object> expectedData1 = new HashMap<>();
        expectedData1.put("userId",1);
        expectedData1.put("id",2);
        expectedData1.put("title","quis ut nam facilis et officia qui");

        // 3. send request get response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData1 = response.as(HashMap.class);

        // 4. do assertion

        assertEquals(expectedData1.get("userId"),actualData1.get("userId"));
        assertEquals(expectedData1.get("id"),actualData1.get("id"));

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


    }
}
