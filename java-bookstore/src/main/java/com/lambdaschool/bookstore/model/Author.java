package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String authorfirstname;
    private String authorlastname;


    @ManyToMany
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    public Author()
    {
    }

    public Author(String authorfirstname, String authorlastname, List<Book> books)
    {
        this.authorfirstname = authorfirstname;
        this.authorlastname = authorlastname;
        this.books = books;
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getAuthorfirstname()
    {
        return authorfirstname;
    }

    public void setAuthorfirstname(String authorfirstname)
    {
        this.authorfirstname = authorfirstname;
    }

    public String getAuthorlastname()
    {
        return authorlastname;
    }

    public void setAuthorlastname(String authorlastname)
    {
        this.authorlastname = authorlastname;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
}
