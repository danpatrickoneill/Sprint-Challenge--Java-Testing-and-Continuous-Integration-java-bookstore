package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController
{
    @Autowired
    BookService bookService;

    @ApiOperation(value = "Updates an existing book", response = Book.class)
    @PutMapping(value = "books/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable long id)
    {
        Book rtnBook = bookService.update(book, id);
        return new ResponseEntity<>(rtnBook, HttpStatus.OK);
    }

    @ApiOperation(value = "Connects an existing book to an author", response = Book.class)
    @PostMapping(value = "books/authors/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> connectBookToAuthor(@RequestBody Book book, @RequestBody Author author, @PathVariable long id)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes an existing book")
    @DeleteMapping(value = "books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id)
    {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
