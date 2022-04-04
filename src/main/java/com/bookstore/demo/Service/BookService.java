package com.bookstore.demo.Service;

import aj.org.objectweb.asm.ModuleVisitor;

import antlr.collections.impl.LList;
import com.bookstore.demo.DTO.Book;
import com.bookstore.demo.Repository.BookeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookeRepo bookeRepo;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookeRepo.findAll().forEach(books::add);    //Iterator<Book>
        return books;
    }

    public Book getBook(int id) {
         var res = bookeRepo.findById(id);
         return res.orElse(null);
    }

    public void addBook(Book book){
        bookeRepo.save(book);

    }


}
