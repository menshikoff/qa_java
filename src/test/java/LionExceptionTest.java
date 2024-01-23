import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {
    @Mock
    Feline feline;

    @Test
    public void createWrongLion() throws Exception {
        try {
            new Lion("Саме", feline);
            Assert.fail("Ожидалось появление исключения");
                    } catch (Exception thrown) {
                        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    thrown.getMessage());
    }
    }
}
