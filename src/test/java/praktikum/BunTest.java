package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private String name;
    private int price;
    private Bun bun;

    public BunTest(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBuns() {
        return new Object[][]{
                {"black bun", 0},
                {" ", -10},
                {"Красная булочка", 300}
        };
    }

    @Test
    public void getNameTest() {
        bun = new Bun(name, price);
        String actual = bun.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals(price, actual, 0);
    }
}