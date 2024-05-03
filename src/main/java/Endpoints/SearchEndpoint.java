package Endpoints;

import io.restassured.response.Response;

public class SearchEndpoint extends BaseEndpoint {
    private final String PATH = "/search.php";

    public SearchEndpoint() {
    }

    public Response searchByMealName(String mealName) {
        return this.baseRequest.request().queryParam("s", new Object[]{mealName})
                .get(this.PATH);
    }
}
