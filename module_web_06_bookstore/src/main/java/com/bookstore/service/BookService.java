package com.bookstore.service;

import com.bookstore.pojo.Book;

import java.util.List;

/**
 * ClassName:BookService
 * Package:com.bookstore.service
 * Description:
 *
 */
public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
