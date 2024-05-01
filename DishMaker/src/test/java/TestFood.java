import Endpoints.SearchEndpoint;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;

@Test
public class TestFood {

    @Test
    @Parameters({"mealName"})
    @Description("Check for the meal name present in all the endpoint")
    public void SearchMealByNameTest(String mealName) {
        SearchEndpoint searchEndpoint = new SearchEndpoint();
        Response response = searchEndpoint.searchByMealName(mealName);
        List<LinkedHashMap> list = response.jsonPath().getList("meals");
        Assert.assertTrue(list.stream().map((meal) -> {
            return meal.get("strMeal").toString();
        }).allMatch((meal) -> {
            return StringUtils.containsIgnoreCase(meal, mealName);
        }), "Meal Name: " + mealName + " is present");
    }
}
