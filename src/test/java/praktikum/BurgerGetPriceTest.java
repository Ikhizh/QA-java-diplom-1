package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceTest {
    Burger burger = new Burger();
    @Mock
    Bun burgerBun = new Bun("black bun", 100F);
    @Mock
    Ingredient burgerIngredient = new Ingredient(FILLING, "sausage", 300F);
    @Mock
    Ingredient secondIngredient = new Ingredient(FILLING, "cutlet", 100);
    @Mock
    Ingredient thirdIngredient = new Ingredient(FILLING, "dinosaur", 200);

    @Test
    public void ShouldGetPrice() {
        burger.setBuns(burgerBun);
        Mockito.when(burgerIngredient.getPrice()).thenReturn(100F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(100f);
        Mockito.when(thirdIngredient.getPrice()).thenReturn(100f);
        Mockito.when(burgerBun.getPrice()).thenReturn(100f);
        burger.addIngredient(burgerIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        float actual = burger.getPrice();
        float expected = burgerBun.getPrice() * 2 + burgerIngredient.getPrice() + secondIngredient.getPrice() + thirdIngredient.getPrice();
        assertEquals(expected, actual, 0);
        System.out.println(actual);
    }

}
