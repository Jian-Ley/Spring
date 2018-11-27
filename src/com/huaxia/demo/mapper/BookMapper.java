package com.huaxia.demo.mapper;


import com.huaxia.demo.model.Book;

public interface BookMapper {
    //Create
    public void createBook(Book book);

    //Update
    public void updateTime(Book book);

    //Read
    public String readName(int id);

    //delete
    public void deleteBook(int id);
}
