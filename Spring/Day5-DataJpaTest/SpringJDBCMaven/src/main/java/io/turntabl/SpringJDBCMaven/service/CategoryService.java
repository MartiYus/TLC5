package io.turntabl.SpringJDBCMaven.service;

import io.turntabl.SpringJDBCMaven.dao.CategoryRepo;
import io.turntabl.SpringJDBCMaven.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo catRepo;

    public List<Category> getAllCategories(){
        return catRepo.findAll();
    }

    public void insertNewCategory(Category cat){
        if (cat.getName() != ""){
            catRepo.save(cat);
        }
    }

    public List<Category> findCategoryByName(String name){
        if (name != ""){
             List<Category> cats = catRepo.findByName(name);
             for (Category cat :cats){
                 //notice it has list of books here but not returned from API call
                 System.out.println(cat);
             }
             return cats;
        }
        else return new ArrayList<>();
    }

    public List<Category> findByFirstLetter(String letter){
        return catRepo.findByNameStartsWith(letter);
    }

    public void deleteById(int id){
        if (id != 0) {
            catRepo.deleteById(id);
        }
    }
}
