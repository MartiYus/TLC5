package io.turntabl.SpringJDBCMaven;

import io.turntabl.SpringJDBCMaven.dao.BookDAO;
import io.turntabl.SpringJDBCMaven.dao.CategoryDAO;
import io.turntabl.SpringJDBCMaven.dto.Book;
import io.turntabl.SpringJDBCMaven.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJdbcMavenApplication implements CommandLineRunner {

	@Autowired
	CategoryDAO catDao;

	@Autowired
	BookDAO bookDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcMavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Category> cats = catDao.getAllCategories();
		for (Category cat : cats){
			System.out.println( cat );
		}

		//Category myCat = new Category();
		//myCat.setName("Graphic Novels");
		//catDao.saveCategory(myCat);

		Book book = bookDao.getBookByISBN("3243525");
		System.out.println(book);

		Book newBook = new Book("43242", "The Book Thief", "Markus Zusak", "Story about a little girl in Nazi GER",
				6, new Date(), "Black Swan", "yes");
		//bookDao.saveBook(newBook);


	}
}
