package praktikum;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {
    Bun burgerBun = new Bun("black bun", 100F);
    Burger burger = new Burger();
    Ingredient burgerIngredient = new Ingredient(FILLING, "sausage", 300F);

    @Test
    public void shouldSetBun() {
        burger.setBuns(burgerBun);
        assertNotNull(burger.bun);
        assertEquals(burger.bun, burgerBun);
    }

    @Test
    public void ingredientShouldBeAdded() {
        burger.addIngredient(burgerIngredient);
        assertThat(burger.ingredients, hasSize(1));
    }

    @Test
    public void ingredientShouldBeRemoved() {
        burger.addIngredient(burgerIngredient);
        burger.removeIngredient(0);
        assertThat(burger.ingredients, hasSize(0));
    }

    @Test
    public void ingredientShouldBeMoved() {
        Ingredient newBurgerIngredient = new Ingredient(FILLING, "cutlet", 100F);
        burger.addIngredient(burgerIngredient);
        int index = burger.ingredients.indexOf(burgerIngredient);
        burger.addIngredient(newBurgerIngredient);
        int newIndex = (burger.ingredients.size() - 1);
        burger.moveIngredient(index, newIndex);
        assertEquals(burger.ingredients.get(0).getType(), newBurgerIngredient.getType());
        assertEquals(burger.ingredients.get(0).getPrice(), newBurgerIngredient.getPrice(), 0);
        assertEquals(burger.ingredients.get(0).getName(), newBurgerIngredient.getName());
    }

}
