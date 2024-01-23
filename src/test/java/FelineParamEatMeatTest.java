import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamEatMeatTest {
    Feline feline = new Feline();
    private final int number;
    private final String expected;

    public FelineParamEatMeatTest(int number, String expected) {
        this.number = number;
        this.expected = expected;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        return new Object[][] {
                { 0, "Животные"},
                { 1 , "Птицы"},
                { 2, "Рыба"}
        };
    }

    @Test
    public void eatMeatReturnListOfDishes() throws Exception {
        assertEquals(expected, feline.eatMeat().get(number));
    }

}
