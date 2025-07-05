package com.piyush.tryJpa.tryJpa.controllers;

import com.piyush.tryJpa.tryJpa.entities.AuthorEntity;
import com.piyush.tryJpa.tryJpa.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) { this.authorService = authorService; }

    @GetMapping("/")
    public String helloFromAuthors() {
        return "Hello from Authors";
    }

    @GetMapping("/getAllAuthors")
    public ResponseEntity<List<AuthorEntity>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.ACCEPTED);
    }

}
