package com.bookstore.dao.impl;

import com.atguigu.myssm.basedao.BaseDAO;
import com.bookstore.dao.BookDAO;
import com.bookstore.pojo.Book;

import java.util.List;

/**
 * ClassName:BookDAO
 * Package:com.bookstore.dao.impl
 * Description:
 *

 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return super.executeQuery("select * from t_book where bookStatus = 0");
    }
    @Override
    public Book getBook(Integer id) {
        return load("select * from t_book where id = ? " , id);
    }
}
