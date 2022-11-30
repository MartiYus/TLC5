package io.turntabl.SpringJDBCMaven.service;

import io.turntabl.SpringJDBCMaven.dao.BookRepo;
import io.turntabl.SpringJDBCMaven.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public void saveBook(Book newBook){
        bookRepo.save(newBook);
    }
}
