
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book first = new Book(001, "Книга Первая", 1000, "Harry White");
    private Book second = new Book(002, "Програмирование для чайников", 1000, "кто то");
    private Book third = new Book(003, "Инструкция", 1000, "Филипп Морис");
    private Book fourth = new Book(003, "Инструкция", 1000, "Филипп Морис");
    private Book fifth = new Book(005, "Hot or not", 1000, "Alex May");
    private Smartphone sixth = new Smartphone(006, "Samsung", 5000, "Южная Корея");
    private Smartphone seventh = new Smartphone(7, "Xiaomi", 5000, "Китай");
    private Smartphone eidhth = new Smartphone(8, "Huawei", 5000, "Китай");
    private Smartphone ninth = new Smartphone(9, "Nokia", 5000, "Финляндия");
    private Smartphone tenth = new Smartphone(010, "Sony", 5000, "Япония");

    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(tenth);

    }

    @Test // Тест сохранить и найти все
    public void testSaveAndFindAll() {
        assertEquals(repository.findAll().length, 5);
    }


    @Test // Тест удаления по ID
    public void shouldRemoveByID() {
        repository.save(first);
        repository.save(second);
        Product[] expected = new Product[]{second};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    private void assertArrayEquals(Product[] expected, Product[] actual) {
    }

    @Test
    public void testRemoveNotExist() {
        repository.removeById(010);
        assertEquals(repository.findAll().length, 4);
    }
}
