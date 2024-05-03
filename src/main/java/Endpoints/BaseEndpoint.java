package Endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class BaseEndpoint {
    protected RequestSpecification baseRequest;
    private final String BASE_URI = "https://www.themealdb.com/api";
    private final String BASE_PATH = "/json/v1/1";

    BaseEndpoint() {
        this.baseRequest = RestAssured.given()
                .log().method()
                .log().uri()
                .log().headers()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .then()
                .response()
                .log().status()
                .expect().request();
    }
}
