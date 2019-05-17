package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktitle;
    private String bookisbn;
    private int bookcopyright;
    private long sectionid;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("books")
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"books", "hibernateLazyInitializer"})
    private Section section;



    public Book()
    {
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
