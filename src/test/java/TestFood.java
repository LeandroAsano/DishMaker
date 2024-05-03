import Endpoints.ListEndpoint;
import Endpoints.SearchEndpoint;
import General.Category;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;

import static java.util.Arrays.stream;

@Test
public class TestFood {

    @Test
    @Parameters({"mealName"})
    @Description("Check for the meal name present in all the endpoint")
    public void searchDishByNameTest(String mealName) {
        SearchEndpoint searchEndpoint = new SearchEndpoint();
        Response response = searchEndpoint.searchByMealName(mealName);
        List<HashMap> list = response.jsonPath().getList("meals");
        Assert.assertTrue(list.stream()
                .map((meal) -> meal.get("strMeal").toString())
                .allMatch((meal) -> StringUtils.containsIgnoreCase(meal, mealName)), "Meal Name: " + mealName + " is present");
    }

    @Test
    @Description("Check for all enum categories present")
    public void checkForCategoriesTest(){
        ListEndpoint listEndpoint = new ListEndpoint();
        Response response = listEndpoint.listCategories();

        List<HashMap> list = response.jsonPath().getList("meals");

        list.stream()
                .map( key -> key.get("strCategory"))
                .map(Object::toString)
                .forEach( cat -> Assert.assertTrue(Category.isPresent(cat),
                        "Category " + cat + " not present"));

    }

}
