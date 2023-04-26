package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;
    private Ingredient burgerIngredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void ingredientShouldGetPrise() {
        burgerIngredient = new Ingredient(type, name, price);
        float actual = burgerIngredient.getPrice();
        Assert.assertEquals(price, actual, 0);
    }

    @Test
    public void ingredientShouldGetName() {
        burgerIngredient = new Ingredient(type, name, price);
        String actual = burgerIngredient.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void ingredientShouldGetType() {
        burgerIngredient = new Ingredient(type, name, price);
        IngredientType actual = burgerIngredient.getType();
        Assert.assertEquals(type, actual);
    }
}
