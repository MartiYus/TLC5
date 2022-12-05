package io.turntabl.SpringJDBCMaven.service;

import io.turntabl.SpringJDBCMaven.dao.CategoryRepo;
import io.turntabl.SpringJDBCMaven.dto.Book;
import io.turntabl.SpringJDBCMaven.dto.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    CategoryRepo catRepo;

    @Autowired
    CategoryService catService;

    @Test
    public void insertNewCategoryEmptyStringTest(){
        Category c = new Category();
        c.setName("");
        c.addBook(new Book());

        catService.insertNewCategory(c);

        verify(catRepo, times(0)).save(any());
    }

    @Test
    public void deleteByIdWithZero(){
        catService.deleteById(0);
        verify(catRepo, times(0)).deleteById(anyInt());
    }

    @Test
    public void deleteByIdWithNonZero(){
        catService.deleteById(2);
        verify(catRepo, times(1)).deleteById(2);
    }
}
