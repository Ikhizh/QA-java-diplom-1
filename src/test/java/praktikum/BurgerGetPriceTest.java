package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetPriceTest {
    Burger burger = new Burger();
    @Mock
    Bun burgerBun;
    @Mock
    Ingredient burgerIngredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
    Ingredient thirdIngredient;

    @Test
    public void shouldGetPrice() {
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
    }

}
