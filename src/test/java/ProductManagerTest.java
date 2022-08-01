
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book first = new Book(001, "Книга Первая", 1000, "Harry White");
    Book second = new Book(002, "Програмирование для чайников", 1000, "кто то");
    Book third = new Book(003, "Инструкция", 1000, "Филипп Морис");
    Book fourth = new Book(003, "Инструкция", 1000, "Филипп Морис");
    Book fifth = new Book(005, "Hot or not", 1000, "Alex May");
    Smartphone sixth = new Smartphone(006, "Samsung", 5000, "Южная Корея");
    Smartphone seventh = new Smartphone(7, "Xiaomi", 5000, "Китай");
    Smartphone eidhth = new Smartphone(8, "Huawei", 5000, "Китай");
    Smartphone ninth = new Smartphone(9, "Nokia", 5000, "Финляндия");
    Smartphone tenth = new Smartphone(010, "Sony", 5000, "Япония");


    @BeforeEach
    public void setup() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eidhth);

    }

    @Test //
    void shouldSearchForSeveralProductsBook() {
        Product[] actual= manager.searchBy("Инструкция");
        Product[]expected = new Product[]{third, fourth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test //
    void shouldSearchForSeveralProductsSmartphone() {
        Product[] actual= manager.searchBy("Китай");
        Product[]expected = new Product[]{seventh, eidhth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test // Тест добавления еще одного элемента
    public void shouldAddOneMore() {
        manager.add(ninth);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh, eidhth, ninth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест использование метода переопределения
    public void shouldEseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }

    @Test // Тест поиска с одинаковыми данными
    public void shouldUseEquals() {
        Product third = new Book(003, "Инструкция", 1000, "Филипп Морис");
        Product fourth = new Book(003, "Инструкция", 1000, "Филипп Морис");
        assertEquals(third, fourth);
    }

    @Test // Тест сохранения всего списка
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second,third, fourth, fifth, sixth, seventh, eidhth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест поиск книги по автору
    public void shouldFindAuthorExistBook() {
        Product[] actual = manager.searchBy("Harry White");
        Product[] expected = new Product[]{first};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест поик книги по названию
    public void shouldFindByBookName() {
        Product[] actual = manager.searchBy("Програмирование для чайников");
        Product[] expected = new Product[]{second};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(actual));
    }

    @Test
        //книги по автору которой нет в списке
    void shouldFindAuthoNotExistBook() {
        manager.add(first);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        //книги по названию которой нет в списке
    void shouldFindNameNotExistBook() {
        manager.add(second);
        Product[] actual = manager.searchBy("Fire and Ice");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test //по модели
    public void shouldFindBySmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test //по стране производителя
    public void shouldFindBySmartphoneTitle() {
        Product[] actual = manager.searchBy("Южная Корея");
        Product[] expected = new Product[]{sixth};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        // по стране производителя которого нет в списке
    void shouldFindМanufacturerNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Индия");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }

    @Test
        // по названию модели которой нет в списке
    void shouldFindNameNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
        System.out.println(Arrays.toString(expected));
    }
}