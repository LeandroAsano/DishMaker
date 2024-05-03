package General;

import java.util.Arrays;

public enum Category {

    BEEF,
    BREAKFAST,
    CHICKEN,
    DESSERT,
    GOAT,
    LAMB,
    MISCELLANEOUS,
    PASTA,
    PORK,
    SEAFOOD,
    SIDE,
    STARTER,
    VEGAN,
    VEGETARIAN;

    Category() {
    }

    public static boolean isPresent(String strCat){
        for (Category category: values()){
            if (category.name().equalsIgnoreCase(strCat))
                return true;
        }
        return false;
    }
}
