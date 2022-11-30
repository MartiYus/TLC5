package io.turntabl.SpringJDBCMaven;

import io.turntabl.SpringJDBCMaven.dto.Book;
import io.turntabl.SpringJDBCMaven.dto.Category;
import io.turntabl.SpringJDBCMaven.service.BookService;
import io.turntabl.SpringJDBCMaven.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJdbcMavenApplication implements CommandLineRunner {

	@Autowired
	CategoryService catService;

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcMavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		List<Category> cats = catService.getAllCategories();
//		for (Category cat : cats){
//			System.out.println( cat );
//		}

//		Category newCat = new Category();
//		newCat.setName("Graphic Novel");
//		Book book = new Book("2332432", "Spiderman", "Stan Lee", "Spiderman does what spider can", newCat, new Date(), "NY", "yes");
//		newCat.addBook(book);
//
//		catService.insertNewCategory(newCat);

		//catService.deleteById(18);

		Category newCat = new Category();
		newCat.setName("Graphic Novel");
		newCat.setId(17);
		catService.insertNewCategory(newCat);


		//catService.insertNewCategory(newCat);

//		List<Category> cats2 = catService.findCategoryByName("Children");
//		for (Category cat : cats2){
//			System.out.println( cat );
//		}

//		List<Category> cats3 = catService.findByFirstLetter("H");
//		for (Category cat : cats3){
//			System.out.println( cat );
//		}

//		List<Book> books = bookService.getAllBooks();
//		for (Book b:books){
//			System.out.println(b);
//		}


//		Book book = bookDao.getBookByISBN("3243525");
//		System.out.println(book);
//
//		Book newBook = new Book("312434", "Wuthering Heights", "Emily bronte", "A romantic historical story",
//				newCat, new Date(), "Black Swan", "yes");
//		bookService.saveBook(newBook);


	}
}
