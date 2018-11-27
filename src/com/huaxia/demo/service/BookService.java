package com.huaxia.demo.service;


import com.huaxia.demo.model.Book;

public interface BookService {
    //Create
    public String createBook(Book book);

    //Update
    public String updateTime(Book book);

    //Read
    public String readName(int id);

    //delete
    public String deleteBook(int id);
}
