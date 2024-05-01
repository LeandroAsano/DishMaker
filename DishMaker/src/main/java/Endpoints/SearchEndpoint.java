package Endpoints;

import io.restassured.response.Response;

public class SearchEndpoint extends BaseEndpoint {
    private final String path = "/search.php";

    public SearchEndpoint() {
    }

    public Response searchByMealName(String mealName) {
        return this.baseRequest.queryParam("s", new Object[]{mealName}).get(this.path, new Object[0]).then().log().status().extract().response();
    }
}
