import com.example.Cat;
import com.example.Feline;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    @Before
    public void createCat() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnMyau() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnNotEmptyList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> menu = cat.getFood();
        MatcherAssert.assertThat(menu.size(), is(not(0)));
    }
}
