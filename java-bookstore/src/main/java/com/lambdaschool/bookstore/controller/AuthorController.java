package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    @Autowired
    AuthorService authorService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<?> getAllAuthors()
    {
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}
