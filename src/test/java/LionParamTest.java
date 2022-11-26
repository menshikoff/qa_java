import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean isManeExpected;

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionParamTest(String sex, boolean isManeExpected) {
        this.sex = sex;
        this.isManeExpected = isManeExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
     @Test
     public void checkMane() throws Exception {
         Lion lion = new Lion(sex, feline);
         MatcherAssert.assertThat(lion.doesHaveMane(), is(isManeExpected));
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(sex, feline);
        MatcherAssert.assertThat(lion.getFood().size(), is(not(0)));
    }

}
