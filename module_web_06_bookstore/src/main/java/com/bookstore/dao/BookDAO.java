package com.bookstore.dao;

import com.bookstore.pojo.Book;
import com.bookstore.pojo.OrderBean;

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
