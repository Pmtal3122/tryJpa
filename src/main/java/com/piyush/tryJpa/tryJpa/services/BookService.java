package com.piyush.tryJpa.tryJpa.services;

import com.piyush.tryJpa.tryJpa.dto.AddBookDto;
import com.piyush.tryJpa.tryJpa.dto.BookAuthorDTO;
import com.piyush.tryJpa.tryJpa.entities.AuthorEntity;
import com.piyush.tryJpa.tryJpa.entities.BookEntity;
import com.piyush.tryJpa.tryJpa.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public List<BookEntity> getAllBooks() {
        log.info("Fetching all books from the repository");
        return bookRepository.findAll();
    }

    public BookEntity addBook(AddBookDto addBookDto) {
        log.info("Adding a new book with name: {}", addBookDto.getName());
        BookEntity book = fromAddBookDto(addBookDto);
        return bookRepository.save(book);
    }

    private BookEntity fromAddBookDto(AddBookDto addBookDto) {
        log.info("Transforming AddBookDto to BookEntity for book name: {}", addBookDto.getName());
        BookEntity book = new BookEntity();

        if (addBookDto.getName() == null || addBookDto.getName().trim().isEmpty())
            throw new IllegalArgumentException("Book name cannot be null or empty");
        book.setName(addBookDto.getName());

        AuthorEntity author = resolveAuthor(addBookDto)
                .orElseThrow(() -> new IllegalArgumentException("Author not found or not provided"));
        book.setAuthor(author);

        return book;
    }

    private Optional<AuthorEntity> resolveAuthor(AddBookDto addBookDto) {
        return getAuthorById(extractAuthorId(addBookDto));
    }

    private Integer extractAuthorId(AddBookDto addBookDto) {
        if (addBookDto.getAuthor() != null) {
            return addBookDto.getAuthor().getId();
        } else {
            if (addBookDto.getAuthorId() == null) {
                throw new IllegalArgumentException("Author information is missing");
            }
            return addBookDto.getAuthorId();
        }
    }

    private Optional<AuthorEntity> getAuthorById(Integer authorId) {
        return authorService.getAuthorById(authorId);
    }

    public List<BookAuthorDTO> getBooksWithAuthorName() {
        return bookRepository.getBooksWithAuthorName();
    }

}
