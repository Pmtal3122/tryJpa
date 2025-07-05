package com.piyush.tryJpa.tryJpa.services;

import com.piyush.tryJpa.tryJpa.dto.BookAuthorDTO;
import com.piyush.tryJpa.tryJpa.entities.BookEntity;
import com.piyush.tryJpa.tryJpa.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

//    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepo) {
        this.bookRepository = bookRepo;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity addBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public List<BookAuthorDTO> getBooksWithAuthorName() {
        return bookRepository.getBooksWithAuthorName();
    }

}
