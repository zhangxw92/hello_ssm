package com.athome.dao;

import com.athome.entity.Book;

import java.util.List;

/**
 * @Author zhangxw03
 * @Dat 2020-11-27 13:31
 * @Describe
 */
public interface BookDao {

    Book get(int id);

    List<Book> list();
}
