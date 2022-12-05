package io.turntabl.SpringJDBCMaven.service;

import io.turntabl.SpringJDBCMaven.dao.BookRepo;
import io.turntabl.SpringJDBCMaven.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book saveBook(Book newBook){
        return bookRepo.save(newBook);
    }

    public Book getBookByIsbn(String isbn){
        Optional<Book> b = bookRepo.findById(isbn);
        if(b.isPresent()){
            return b.get();
        }
        else return new Book();
    }
}
