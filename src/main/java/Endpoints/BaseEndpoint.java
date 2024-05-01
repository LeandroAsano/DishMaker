package Endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseEndpoint {
    protected RequestSpecification baseRequest;
    private final String BASE_URI = "https://www.themealdb.com/api";
    private final String BASE_PATH = "/json/v1/1";

    BaseEndpoint() {
        new ResponseLoggingFilter();
        this.baseRequest = ((RequestSpecification)RestAssured.given().log().method().log().uri().log().headers()).contentType(ContentType.JSON).baseUri("https://www.themealdb.com/api").basePath("/json/v1/1");
    }
}
