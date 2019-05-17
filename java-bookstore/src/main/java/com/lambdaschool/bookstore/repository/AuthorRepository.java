package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{

}
