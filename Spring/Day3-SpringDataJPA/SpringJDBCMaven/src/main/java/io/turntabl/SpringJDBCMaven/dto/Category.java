package io.turntabl.SpringJDBCMaven.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "cat", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    public void addBook(Book b){
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(b);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book b:books){
            sb = sb.append(new StringBuilder(b.toString()));
        }
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books = " + sb +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
