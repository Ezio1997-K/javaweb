package com.bookstore.service.impl;

import com.bookstore.dao.BookDAO;
import com.bookstore.pojo.Book;
import com.bookstore.service.BookService;

import java.util.List;

/**
 * ClassName:BookServiceImpl
 * Package:com.bookstore.service.impl
 * Description:
 *
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
