package com.piyush.tryJpa.tryJpa.services;

import com.piyush.tryJpa.tryJpa.entities.AuthorEntity;
import com.piyush.tryJpa.tryJpa.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) { this.authorRepository = authorRepository; }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

}
