package com.giit.www.college.dao;

import com.giit.www.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
     int add(Book book);
     List<Book> findBookAll();
     Book find(@Param("bookTitle") String bookTitle, @Param("isbn") String isbn);
}
