package com.bookstore.demo.Controller;

import com.bookstore.demo.DTO.Book;
import com.bookstore.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public List<Book> getAll(){
        return bookService.getAllBooks();
    }
  @GetMapping("/book/{id}")
    public Book get(@PathVariable int id){
        var res= bookService.getBook(id);
        return (res != null ? res:new Book());
    }
  @PostMapping("/book")
    public void add(@RequestBody Book book){
        bookService.addBook(book);
    }



}
