package io.turntabl.SpringJDBCMaven.repository;

import io.turntabl.SpringJDBCMaven.dao.CategoryRepo;
import io.turntabl.SpringJDBCMaven.dto.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@PropertySource("test-app.properties")
public class CategoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    CategoryRepo repository;

    @Test
    public void findAllReturnsEmpyList() {
        Iterable cats = repository.findAll();
        assertThat(cats).isEmpty();
    }

    @Test
    public void saveCategoryTest() {
        Category c = new Category();
        c.setName("new cat");
        c.setId(1);
        Category cat = repository.save(c);

        assertThat(cat).hasFieldOrPropertyWithValue("name", "new cat");
        assertThat(cat).hasFieldOrPropertyWithValue("id", 1);
    }

    @Test
    public void returnsCategoriesStartingWithLetter(){
        Category c = new Category();
        c.setName("new cat");
        c.setId(1);
        repository.save(c);

        Category c2 = new Category();
        c2.setName("another cat");
        c.setId(2);
        repository.save(c2);

        List<Category> cats = repository.findByNameStartsWith("a");
        assertThat(cats).hasSize(1);
        Category result = cats.get(0);
        assertThat(result.getName()).isEqualTo("another cat");

    }
}
