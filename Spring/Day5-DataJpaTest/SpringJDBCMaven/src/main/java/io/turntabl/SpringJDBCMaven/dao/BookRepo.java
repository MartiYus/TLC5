package io.turntabl.SpringJDBCMaven.dao;

import io.turntabl.SpringJDBCMaven.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {
}
