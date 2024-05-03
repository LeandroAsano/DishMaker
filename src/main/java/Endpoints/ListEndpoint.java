package Endpoints;

import io.restassured.response.Response;

public class ListEndpoint extends BaseEndpoint{

    private final String PATH = "list.php";

    public ListEndpoint() {}

    public Response listCategories(){
        return baseRequest
                .queryParam("c","list")
                .get(this.PATH);

    }

    public Response listAreas(){
        return baseRequest
                .queryParam("a","list")
                .get(this.PATH);
    }

    public Response listIngredientes(){
        return baseRequest
                .queryParam("i","list")
                .get(this.PATH);
    }
}
