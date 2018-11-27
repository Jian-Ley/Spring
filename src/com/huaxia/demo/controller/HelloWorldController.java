package com.huaxia.demo.controller;

import com.huaxia.demo.model.Book;
import com.huaxia.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorldController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/helloJson")
    @ResponseBody
    public String helloWorld() {
        return "helloJson";
    }

    @RequestMapping("/helloJsp")
    public ModelAndView helloJsp() {
        Map map = new HashMap();
        map.put("title", "Hello title!");
        map.put("end", "Hello end!");

        return new ModelAndView("helloJsp", map);
    }

    @RequestMapping(value = "/readName")
    @ResponseBody
    public String readName() {
        String name = bookService.readName(1);
        System.out.println("readName:" + name);
        return "True! Look at that book: " + name;
    }

    @RequestMapping("/createBook")
    @ResponseBody
    public String createBook() {
        Book bookTest = new Book();
        bookTest.setId(21);
        bookTest.setName("No.21");
        bookTest.setAuthor("You");
        bookTest.setPublishedTime("20181127");
        String resultStr = bookService.createBook(bookTest);
        System.out.println("True! Creating book Successfully!");
        return resultStr+"Creating book Successfully!";
    }
    //Update
    @RequestMapping("/updateTime")
    @ResponseBody
    public String updateTime(){
        Book bookTest2 = new Book();
        bookTest2.setId(1);
        bookTest2.setPublishedTime("20101111");
        String str = bookService.updateTime(bookTest2);
        System.out.println("True! Updating book's time Successfully!");
        return str;
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(){
		String str = bookService.deleteBook(21);
		System.out.println("True! Deleting book Successfully!");
        return str;
    }
}