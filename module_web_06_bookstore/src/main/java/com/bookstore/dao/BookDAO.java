package com.bookstore.dao;

import com.bookstore.pojo.Book;

import java.util.List;

/**
 * ClassName:BookDAO
 * Package:com.bookstore.dao.impl
 * Description:
 *
 */
public interface BookDAO {
   List<Book> getBookList();
   Book getBook(Integer id);
}
