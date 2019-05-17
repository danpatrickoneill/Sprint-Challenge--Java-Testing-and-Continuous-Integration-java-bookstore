package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookrepo;

    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();
        bookrepo.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Transactional
    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setBooktitle(book.getBooktitle());
        newBook.setBookisbn(book.getBookisbn());
        newBook.setBookcopyright(book.getBookcopyright());
        newBook.setAuthors(book.getAuthors());

        return bookrepo.save(newBook);
    }

    @Override
    public Book update(Book book, long id) throws EntityNotFoundException
    {


        if (bookrepo.findById(id).isPresent()) {
            Book currentBook = bookrepo.findById(id).get();

            if (book.getBookisbn() != null) {
                currentBook.setBookisbn(book.getBookisbn());
            }
            if (book.getBooktitle() != null) {
                currentBook.setBooktitle(book.getBooktitle());
            }
            if (book.getBookcopyright() != 0) {
                currentBook.setBookcopyright(book.getBookcopyright());
            }
            if (book.getAuthors() != null) {
                currentBook.setAuthors(book.getAuthors());
            }

            return bookrepo.save(currentBook);

        }

        throw new EntityNotFoundException("Couldn't find book with id: " + id);
    }

    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (bookrepo.findById(id).isPresent()) {
            bookrepo.deleteById(id);
        }

        throw new EntityNotFoundException("Couldn't find book with id: " + id);
    }
}
