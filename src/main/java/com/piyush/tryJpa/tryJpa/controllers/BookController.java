package com.piyush.tryJpa.tryJpa.controllers;

import com.piyush.tryJpa.tryJpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piyush.tryJpa.tryJpa.entities.BookEntity;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String helloFromBooks() {
        return "Hello from Books!";
    }

    @GetMapping("/getAllBooks")
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/addBook", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity) {
        BookEntity addedBook = bookService.addBook(bookEntity);
        return new ResponseEntity<BookEntity> (addedBook, HttpStatus.ACCEPTED);
    }
}
