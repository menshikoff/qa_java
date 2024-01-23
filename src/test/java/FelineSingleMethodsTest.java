import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineSingleMethodsTest {
    Feline feline;

    @Before
    public void createFeline() {
        feline = new Feline();
    }

    @Test
    public void getKittensNoArgumentsReturnOneAmount() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensTenReturnTenAmount() {
        assertEquals(10, feline.getKittens(10));
    }

    @Test
    public void getFamilyReturnKoshachy() {
        assertEquals("Кошачьи", feline.getFamily());
    }


}
