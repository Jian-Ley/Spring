package com.huaxia.demo.service;

import com.huaxia.demo.mapper.BookMapper;
import com.huaxia.demo.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BookServiceImpl implements BookService{

//    @Autowired
    @Resource
    private BookMapper bookMapper;

    //Create
    @Override
    public String createBook(Book book){
//        String name = bookMapper.createBook(book);
        //create方法没有返回值
        bookMapper.createBook(book);
        return "book:"+ book.getName();
    }

    //Update
    @Override
    public String updateTime(Book book){
        bookMapper.updateTime(book);
        return "True! Updating book's time Successfully!"+ book.getPublishedTime();
    }

    //Read
    @Override
    public String readName(int id){
        String bookName = bookMapper.readName(id);
        return bookName;
    }

    //delete
    @Override
    public String deleteBook(int id){
        bookMapper.deleteBook(id);
        return "True! Deleting book Successfully!";
    }
}
