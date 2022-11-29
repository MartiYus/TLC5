package io.turntabl.SpringJDBCMaven.dao;

import io.turntabl.SpringJDBCMaven.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getAllBooks(){
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BookRowMapper());
        return books;
    }

    public Book getBookByISBN(String isbn){
        String sql = "select * from book where isbn =?";
        Book book = jdbcTemplate.queryForObject(sql,new BookRowMapper(), isbn);
        return book;
    }

    public void saveBook(Book newBook){
        String sql = "insert into book values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getDescription(),
                newBook.getCategory_id(), newBook.getPub_Date(), newBook.getPublisher(), newBook.getAvailability());

    }

    private class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setIsbn(rs.getString(1));
            book.setAuthor(rs.getString(3));
            book.setCategory_id(rs.getInt(5));
            book.setTitle(rs.getString(2));
            book.setDescription(rs.getString(4));
            book.setPublisher(rs.getString(7));
            book.setPub_Date(rs.getDate(6));
            book.setAvailability(rs.getString(8));
            return book;
        }
    }
}
