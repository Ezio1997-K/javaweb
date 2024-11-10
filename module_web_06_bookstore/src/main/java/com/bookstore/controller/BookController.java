package com.bookstore.controller;

import com.bookstore.pojo.Book;
import com.bookstore.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:BookController
 * Package:com.bookstore.controller
 * Description:
 *
 */
public class BookController {
    private BookService bookService;
    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }
}
