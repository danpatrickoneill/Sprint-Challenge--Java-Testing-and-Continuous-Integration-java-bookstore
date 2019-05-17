package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktitle;
    private String bookisbn;
    private int bookcopyright;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    public Book()
    {
    }

    public Book(String booktitle, String bookisbn, int bookcopyright, List<Author> authors)
    {
        this.booktitle = booktitle;
        this.bookisbn = bookisbn;
        this.bookcopyright = bookcopyright;
        this.authors = authors;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getBookisbn()
    {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn)
    {
        this.bookisbn = bookisbn;
    }

    public int getBookcopyright()
    {
        return bookcopyright;
    }

    public void setBookcopyright(int bookcopyright)
    {
        this.bookcopyright = bookcopyright;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}
