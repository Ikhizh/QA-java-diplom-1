package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {
    @Mock
    Bun burgerBun;
    @Mock
    Ingredient burgerIngredient;

    @Test
    public void shouldGetReceipt() {
        Burger burger = new Burger();
        Mockito.when(burgerBun.getName()).thenReturn("black bun");
        Mockito.when(burgerIngredient.getType()).thenReturn(FILLING);
        Mockito.when(burgerIngredient.getName()).thenReturn("sausage");
        burger.setBuns(burgerBun);
        burger.addIngredient(burgerIngredient);
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains(burgerBun.getName()));
        Assert.assertTrue(receipt.contains(burgerIngredient.getType().toString().toLowerCase()));
        Assert.assertTrue(receipt.contains(burgerIngredient.getName()));
    }
}
