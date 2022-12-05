package io.turntabl.SpringJDBCMaven.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.turntabl.SpringJDBCMaven.dto.Book;
import io.turntabl.SpringJDBCMaven.dto.Category;
import io.turntabl.SpringJDBCMaven.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @MockBean
    BookService bookService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void testGetAllBooks() throws Exception{
        ArrayList<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setTitle("Book1");
        Book b2 = new Book();
        b2.setTitle("Book2");
        Book b3 = new Book();
        b3.setTitle("Book3");
        books.add(b1);
        books.add(b2);
        books.add(b3);

        doReturn(books).when(bookService).getAllBooks();

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("Book1"))
                .andExpect(jsonPath("$[1].title").value("Book2"))
                .andExpect(jsonPath("$[2].title").value("Book3"));
    }

    @Test
    public void testSaveNewBook() throws Exception{
        Book book = new Book();
        book.setTitle("Book1");
        Category c = new Category();
        c.setName("History");
        book.setCat(c);

        doReturn(new Book()).when(bookService).saveBook(any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/books")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result =  mockMvc.perform(requestBuilder).andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
