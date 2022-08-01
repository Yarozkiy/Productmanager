import org.junit.jupiter.api.Test;
import ru.netology.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldGetAndSet() {
        Book book = new Book();
        String expected = "Harry White";
        assertNull(book.getAuthor());
        book.setAuthor(expected);
        assertEquals(expected, book.getAuthor());
    }
}