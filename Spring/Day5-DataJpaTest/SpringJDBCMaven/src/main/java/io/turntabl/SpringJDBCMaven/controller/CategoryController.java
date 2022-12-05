package io.turntabl.SpringJDBCMaven.controller;

import io.turntabl.SpringJDBCMaven.dto.Category;
import io.turntabl.SpringJDBCMaven.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService catService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/categories")
    public ModelAndView getAllCategories(){
       List<Category> cats =  catService.getAllCategories();
        Map<String, Object> params = new HashMap<>();
        params.put("cats", cats);
        return new ModelAndView("categories", params);
    }
}
