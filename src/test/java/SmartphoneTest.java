
import org.junit.jupiter.api.Test;
import ru.netology.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldGetAndSet() {
        Smartphone smartphone = new Smartphone(9, "Nokia", 5000, "Финляндия");
        String expected = "Финляндия";
        smartphone.getManufacturer();
        smartphone.setManufacturer(expected);
        assertEquals(expected, smartphone.getManufacturer());
        System.out.println(expected);
    }
}