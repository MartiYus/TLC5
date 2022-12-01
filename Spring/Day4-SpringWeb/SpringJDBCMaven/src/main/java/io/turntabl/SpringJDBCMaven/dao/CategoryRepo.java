package io.turntabl.SpringJDBCMaven.dao;

import io.turntabl.SpringJDBCMaven.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findByName(String name);

    @Query(value = "select * from category where name like :letter%", nativeQuery = true)
    List<Category> findByNameStartsWith(@Param("letter") String letter);
}
