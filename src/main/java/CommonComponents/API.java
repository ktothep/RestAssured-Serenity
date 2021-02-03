package CommonComponents;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class API {
    private String URL;
    private RequestSpecification requestSpecification;




    private Response response;

    public API switchURL(String baseURI)
    {
        URL=baseURI;
        return this;
    }

    public API initRequest()
    {
        requestSpecification= SerenityRest.given().relaxedHTTPSValidation();
        return this;
    }

    public<T> API get(String endpoint)
    {
        response=requestSpecification.baseUri(URL)
                .when()
                .get(endpoint);

        return this;
    }

    public<T> API post(String endpoint, String body, Map<String,?> pathParam, Map<String,?> queryParam)
    {
        requestSpecification.baseUri(URL)
                .body(body).pathParams(pathParam).queryParams(queryParam)
                .when()
                .post(endpoint);

        return this;
    }
    public<T> API post(String endpoint, String body)
    {
        requestSpecification.baseUri(URL)
                .body(body)
                .when()
                .post(endpoint);

        return this;
    }

    public int statusCode()
    {
        return  SerenityRest.lastResponse().getStatusCode();
    }

    public String response()
    {
        return SerenityRest.lastResponse().asString();
    }

}
