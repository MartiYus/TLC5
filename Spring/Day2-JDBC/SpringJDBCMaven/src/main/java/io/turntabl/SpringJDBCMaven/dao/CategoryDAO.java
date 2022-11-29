package io.turntabl.SpringJDBCMaven.dao;

import io.turntabl.SpringJDBCMaven.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories(){
        String sql = "select * from category";
        return jdbcTemplate.query(sql, new CategoryRowMapper() );
    }

    public void saveCategory(Category cat){
        String sql = "insert into category(name) values(?)";
        jdbcTemplate.update(sql, cat.getName());
    }

    private class CategoryRowMapper implements RowMapper<Category>{

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category cat = new Category();
            cat.setId(rs.getInt(1));
            cat.setName(rs.getString(2));
            return cat;
        }
    }

}
