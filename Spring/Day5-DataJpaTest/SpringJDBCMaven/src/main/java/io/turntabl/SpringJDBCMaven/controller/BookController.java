package io.turntabl.SpringJDBCMaven.controller;

import io.turntabl.SpringJDBCMaven.dto.Book;
import io.turntabl.SpringJDBCMaven.dto.Category;
import io.turntabl.SpringJDBCMaven.service.BookService;
import io.turntabl.SpringJDBCMaven.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService catService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/category/{name}")
    public String helloThere(){
        return "hello";
    }

    @GetMapping("/books/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn){
        return bookService.getBookByIsbn(isbn);
    }

//    @PostMapping("/books")
//    public Book createANewBook(@RequestBody Book b){
//        return bookService.saveBook(b);
//    }

    @PostMapping("/books")
    public HttpStatus saveNewBook(@RequestBody Book b){
        Book result = bookService.saveBook(b);
        if (result == null){
            return HttpStatus.PRECONDITION_FAILED;
        }
        else{
            return HttpStatus.CREATED;
        }
    }

    @GetMapping("/category/{name}")
    public List<Category> getBooksByCategoryName(@PathVariable String name){
        return catService.findCategoryByName(name);
    }
}
