package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;

import java.util.List;

public interface BookService
{
    List<Book> findAll();

    Book save(Book book);

    Book update(Book book, long id);

    void delete(long id);
}
