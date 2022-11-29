package io.turntabl.SpringJDBCMaven.dto;

import java.util.Date;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private String description;

    public Book( String isbn, String title, String author, String description, int category_id,  Date pub_Date, String publisher, String availability) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.description = description;
        this.pub_Date = pub_Date;
        this.category_id = category_id;
        this.publisher = publisher;
        this.availability = availability;
    }

    public Book() {
    }

    private Date pub_Date;

    public Date getPub_Date() {
        return pub_Date;
    }

    public void setPub_Date(Date pub_Date) {
        this.pub_Date = pub_Date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    private int category_id;
    private String publisher;
    private String availability;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", pub_Date=" + pub_Date +
                ", category_id=" + category_id +
                ", publisher='" + publisher + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
