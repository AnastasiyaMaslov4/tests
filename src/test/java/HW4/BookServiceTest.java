package HW4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BookServiceTest {

    @Test
    public void testBookService() {
        BookRepository bookRepo = mock(BookRepository.class);

        BookService bookService = new BookService(bookRepo);

        bookService.findBookById("1");

        bookService.findAllBooks();

        verify(bookRepo).findById("1");
    }
}