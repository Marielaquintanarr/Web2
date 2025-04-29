package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// comentario
@Entity
@Table(name = "books") // This specifies the table name in the database
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate IDs
    private Long id;

    @NotNull // This field cannot be null
    @Size(max = 255) // Maximum length for the title
    @Column(nullable = false) // This column cannot be null in the database
    private String title;

    @NotNull // This field cannot be null
    @Size(max = 255) // Maximum length for the author name
    @Column(nullable = false) // This column cannot be null in the database
    private String author;

    @NotNull // This field cannot be null
    @Size(min = 10, max = 20) // ISBN length validation
    @Column(unique = true, nullable = false) // This column must be unique and cannot be null
    private String isbn;

    @NotNull // This field cannot be null
    @Min(1000) // Minimum value for the publication year
    private Integer publicationYear;

    @Size(max = 100) // Maximum length for the genre
    private String genre;

    @Min(1) // Minimum value for the number of pages
    private Integer pages;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    // createdAt does not need a setter because it's auto-generated
}