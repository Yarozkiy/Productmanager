import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product = new Book(003, "Инструкция", 1000, "Филипп Морис");

    @Test
    public void shouldUseEquals() {
        Product third = new Product(003, "Инструкция", 1000);
        Product fourth = new Product(003, "Инструкция", 1000);
        assertEquals(third, fourth);
    }

    @Test
    public void shouldGetNameAndSetName() {
        String expected = "Инструкция";
        product.getName();
        product.setName(expected);
        assertEquals(expected, product.getName());
    }

    @Test
    public void shouldGetIDAndSetId() {
        product.setId(003);
        assertEquals(003, product.getId());
    }

    @Test
    public void shouldSetPrice() {
        product.setPrice(1000);
        product.getPrice(1000);
        assertEquals(1000, 1000);

    }
}
