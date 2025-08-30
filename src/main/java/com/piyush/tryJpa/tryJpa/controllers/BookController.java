package com.piyush.tryJpa.tryJpa.controllers;

import com.piyush.tryJpa.tryJpa.dto.AddBookDto;
import com.piyush.tryJpa.tryJpa.dto.BookAuthorDTO;
import com.piyush.tryJpa.tryJpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piyush.tryJpa.tryJpa.entities.BookEntity;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

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

    @GetMapping("/getBooksWithAuthorName")
    public ResponseEntity<List<BookAuthorDTO>> getBooksWithAuthorName() { return new ResponseEntity<>(bookService.getBooksWithAuthorName(), HttpStatus.ACCEPTED); }

    @PostMapping(value = "/addBook", consumes = "application/json")
    public ResponseEntity<?> addBook(@RequestBody AddBookDto addBookDto) {
        try {
            BookEntity addedBook = bookService.addBook(addBookDto);
            return ResponseEntity.ok(addedBook);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
